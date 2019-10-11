import processing.core.PApplet;


class aa extends PApplet{
    public void setup() {
        setSize(500, 500);
        background(150,150,150);
        for(int i=0;i<19;i++){
            line((float)0, (float)500/19*i, (float)500.0, (float)500/19*i);
        }
        for(int i=0;i<19;i++){
            line((float)500/19*i, (float)0, (float)500/19*i,(float)500.0);
        }
    }
}

/**
 * wjy
 */
public class wjy {

    public static void main(String[] args) {
        aa e=new aa();
    }
}