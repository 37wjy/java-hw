//import processing.core.*;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import processing.*;

/**
 * Hello world!
 *
 */


public class Win4 extends JFrame{


    public Win4(Color bg, Color fg, int w, int h) {
        setSize(w,h);
        Container c=getContentPane();
        
        c.setBackground(bg);
        c.setForeground(fg);
        setVisible(true);
        //c.add(BorderLayout.WEST,b);
        
        		
    }

   public static void main(String[] args) {
        Win4 a=new Win4(Color.black,Color.blue,200,300);
    }
}


