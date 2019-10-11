import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

public class ListTest{
    public static void main(String[] args) {
        ArrayList<Point> points=new ArrayList<Point>();
        points.add(new Point(2,3));
        points.add(new Point(4,100));
        for (int i = 0; i < points.size(); i++) {
            System.out.println(points.get(i)+" ");
        }
        System.out.println();
        for (Iterator<Point> i = points.iterator(); i.hasNext(); ) {
            Point p=i.next();
        }
        JFrame f=new JFrame();



        f.setSize(400,400);
        f.addWindowListener(new WindowListener(){
        
            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
    
    
        Airplane a[]=new Airplane[2];
        a[0]=new Airplane(){
        
            @Override
            public void takeoff() {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void landing() {
                // TODO Auto-generated method stub
                
            }
        
            @Override
            public void fly() {
                // TODO Auto-generated method stub
                
            }
        };
        
        
    }
}


/**
 * airplane
 */
interface Airplane {
    public void fly();
    public void takeoff();
    public void landing();
};

abstract class C2 {
    int x;
    abstract int tr();
    int getx(){
        return x;
    }
};




