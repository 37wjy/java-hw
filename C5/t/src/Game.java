
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.Component;

public class Game extends JFrame{

    public void menu(){
        JMenuBar m = new JMenuBar();
        JMenu mm= new JMenu();
        JMenuItem mi=new JMenuItem();
        mm.add(mi);
        //mi.addActionListener(new Actionlisener(){
          //  public void ac(ActioncEvent a){//interface
                
            //}
        //});
        m.add(mm);
        setJMenuBar(m);
    }
    
    public Game(){
        super();//调superclass const
        setSize(1000,1000);
        menu();
        setVisible(true);

    }

    /* class Gamebord extends JPanel{
        public Gamebord(){
            addMouseListener();

        }
        
        public void jjjjijijijijijij(){
            super.paint();

        } */

        
    //}

    public static void main(String[] args) {
        Game a=new Game();
    }


}