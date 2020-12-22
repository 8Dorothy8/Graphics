import processing.core.PApplet;
import processing.core.PImage;

public class Movement2 extends PApplet {
PImage pic;
    public static void main(String[] args) {
        PApplet.main("Movement2");
    }

    public float speed = 3;
    public float fastSpeed = 6;
    public float x = 400;
    public float y = 350;

    public boolean moveForward = false;
    public boolean moveAccelerate = false;
    public boolean moveBackward = false;
    public boolean moving = false;
    public boolean thrusters = false;
    public float rotationAmount = 0;
    public boolean rotatingLeft = false;
    public boolean rotatingRight = false;
    // public boolean backTurn = false;

    public void settings() {

        size(1000, 800);
    }

    public void setup() {
        pic = loadImage("images/Space.png");
        background(78,9,227);
    }

    public void draw() {
        pic.resize(950,750);
        image(pic,25,25);

        //Move and control the rocket ship.
        move();
        turn();
        translate(x, y);
        rotate(rotationAmount);
        drawRocketShip();
    }

    //Set up and draw the rocket ship.
    public int rocketX = 0;
    public int rocketY = 0;

    public void drawRocketShip() {
        //Body color.
        stroke(0, 149, 185);
        fill(230, 73, 34);
        //Body
        rect(rocketX, rocketY, 75, 50);
        //front
        triangle(rocketX + 75, rocketY + 1, 100, rocketY + 25, rocketX + 75, rocketY + 49);
        //window color
        fill(255, 255, 255);
        //window
        ellipse(rocketX + 60, rocketY + 25, 30, 15);
        //wings
        stroke(0, 149, 185);
        strokeWeight(3);
        fill(0, 60, 80);
        triangle(rocketX + 25, rocketY, rocketX - 15, rocketY - 25, rocketX, rocketY);
        triangle(rocketX + 25, rocketY + 50, rocketX - 15, rocketY + 75, rocketX, rocketY + 50);

        if (moving) {
            //Fire trail
            fill(230, 100, 10);
            noStroke();
            triangle(rocketX - 10, rocketY + 10, rocketX - 30, rocketY + 25, rocketX - 10, rocketY + 40);
        }
        if (thrusters) {
            fill(230,100,10);
            noStroke();
            triangle(rocketX - 10, rocketY + 10, rocketX - 30, rocketY + 25, rocketX - 10, rocketY + 40);
            fill(255,0,0);
            triangle(rocketX - 20, rocketY + 10, rocketX - 40, rocketY + 25, rocketX - 20, rocketY + 40);
        }
    }

    public void keyPressed() {
        if (key == 'w') {
            moveForward = true;
            moving = true;
        }
        if (key == ' ') {
            moveAccelerate = true;
            thrusters = true;
        }

        if (key == 's') {
            moveBackward = true;
            moving = true;
            // rotate(backTurn);
        }

        if(key == 'a') {
            rotatingLeft = true;
        }

        if(key == 'd') {
            rotatingRight = true;
        }
    }

    public void keyReleased() {
        if (key == 'w') {
            moveForward = false;
            moving = false;
        }
        if (key == ' ') {
            moveAccelerate = false;
            thrusters = false;
        }

        if (key == 's') {
            moveBackward = false;
            moving = false;
        }

        if (key == 'a') {
            rotatingLeft = false;
        }

        if (key == 'd') {
            rotatingRight = false;
        }
    }
    public void turn() {
        if(rotatingLeft) {
            if (rotationAmount > 0) {
                rotationAmount -= 0.05;
            } else {
                rotationAmount = 2 * PI;
            }
        }
            if (rotatingRight) {
                if(rotationAmount < 2 * PI) {
                    rotationAmount += 0.05;
                }
                else {
                    rotationAmount = 0;
                }
            }
        }

   /* public void backTurn() {
        rotate(PI);
    }
*/
    public void move() {
        if (moveForward) {
            x += speed * cos(rotationAmount);
            y += speed * sin(rotationAmount);
        }
        if (moveBackward) {
            x -= speed * cos (rotationAmount);
            y -= speed * sin(rotationAmount);
        }
        if (moveAccelerate) {
            x += fastSpeed * cos(rotationAmount);
            y += fastSpeed * sin(rotationAmount);
        }
    }
}