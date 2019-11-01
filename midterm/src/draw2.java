import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * draw2
 */
public class draw2 extends JFrame{

    public static void main(String[] args) {
        draw2 b=new draw2();
    }

    void gg(JPanel jp){
        Graphics g=jp.getGraphics();//返回null
        g.drawLine(10, 10, 100, 300);
    }

    public draw2(){
        super();
        setSize(400,400);
        setDefaultCloseOperation(3);
        JPanel a=new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawLine(1, 1, 100, 222);
            }
        };
        add(a);
        //gg(a);
        setVisible(true);
    }
}