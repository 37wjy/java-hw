import processing.core.PApplet;


public class wjy extends PApplet{

    public void settings() {
        setSize(500, 500);
    }
    public void setup() {
        
        background(150,150,150);
        for(int i=0;i<19;i++){
            line((float)0, (float)500/19*i, (float)500.0, (float)500/19*i);
        }
        for(int i=0;i<19;i++){
            line((float)500/19*i, (float)0, (float)500/19*i,(float)500.0);
        }
    }

    public void draw(){
    }

    public static void main(String[] args) {
        PApplet.main("wjy");
    }



}