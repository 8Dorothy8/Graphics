import processing.core.PApplet;
import processing.core.PImage;

public class Test extends PApplet {
PImage pic;
    public static void main(String[] args) {
        PApplet.main("Test");
    }
    // literally settings
    public void settings() {
        size(900, 600);
        //size in pixels of your program
    }
    //runs once at start
    public void setup() {
        pic = loadImage("images/img.png");
        pic = loadImage("images/Man.png");
        background(0,200,200);
        //can make different color background 0-255 with RGB
    }
    // Runs once per frame
    public void draw() {
        stroke(0,0,0); //outside/stroke color
        strokeWeight(10); //number of pixels the outline thickness is
        fill(200,50,60); //Fill inside shape color
        circle(400,400,200);
        line(250,200,250,590);
        line(250,500,350,530);
        circle(400,540,100);
        line(460,550,560,500);

        pic.resize(850,550);
        image(pic,25,25);
        tint(60,0,0,alpha(10));
    }
}
