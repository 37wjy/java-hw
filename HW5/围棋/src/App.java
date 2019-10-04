
//@wjy by VScode

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = -2895958051937760342L;
    static int x = 800, y = 800;
    static int side=40;
    Graphics g;
    public App(){
        
        JFrame 狗日的=new JFrame("围棋   (其实是五子棋)");
        狗日的.setSize(x,y+20);
        狗日的.setDefaultCloseOperation(3);
        狗日的.setResizable(false);
        狗日的.setBackground(new Color(70, 230, 190));
        JPanel 艹=new JPanel(){
                /**
            *
            */
            private static final long serialVersionUID = -8382137159490262267L;
            int side = App.side;
                @Override
                public void paint(Graphics gg){
                    for(int i=0;i<19;i++){
                        gg.drawLine(side, (int)((y-2*side)/18.0*i+side), x-side, (int)((y-2*side)/18.0*i+side));
                    }
                    for(int i=0;i<19;i++){
                        gg.drawLine((int)((x-2*side)/18.0*i+side),side, (int)((x-2*side)/18.0*i+side),  y-side);
                    }
                    g=gg;
                    呵呵 呵=new 呵呵(this);
                    this.addMouseListener(呵);
                }                
            };
        狗日的.add(艹);
        狗日的.setVisible(true);
    }

    class 呵呵 extends MouseAdapter{
        int x=800,y=800;
        int side=40;
        boolean f=true;
        boolean[][] bw=new boolean[19][19];
        boolean[][] bb=new boolean[19][19];
        Graphics2D gg;
        public 呵呵(JPanel 呵){
            for(int z=0;z<19;z++){
                for(int zz=0;zz<19;zz++){bw[z][zz]=false;bb[z][zz]=false;}
            }
            gg=(Graphics2D)呵.getGraphics();
        }
    
        public void mouseReleased(MouseEvent 咔){
            int mx=咔.getX();
            int my=咔.getY();
            
            if(mx>side-15&&mx<x-side+15&&my>side-15&&my<y-side+15){
                mx=(int)((mx-(side-30))/(780/19.0));
                my=(int)((my-(side-30))/(780/19.0));//又不是不能用，就是不太准
                
                    if(!bw[mx][my]&&!bb[mx][my]){
                        if(f){
                            gg.setColor(Color.black);bb[mx][my]=true;
                        }
                        else{
                            gg.setColor(Color.white);bw[mx][my]=true;
                        }
                        f=f?false:true;
                        gg.fillOval((int)((x-2*side)/18.0*mx+side)-15, (int)((y-2*side)/18.0*my+side)-15, 30, 30);
                        gg.setColor(new Color(200,100,200));
                        gg.drawOval((int)((x-2*side)/18.0*mx+side)-15, (int)((y-2*side)/18.0*my+side)-15, 30, 30);
                    
                }  
            }
        }
    }

    public static void main(String[] args) {
        App a=new App();
    }
}

