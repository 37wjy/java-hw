import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Cao extends JFrame {
    private JTextField scr;
    private JButton    b;


    public Cao(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        Container c = getContentPane();
        c.setBackground(new Color(0,0,0));

        scr =  new JTextField();
        scr.setBackground(new Color(0,0,0));
        scr.setForeground(new Color(244,244,244));
        scr.setFont(new Font("宋体",Font.BOLD,30));
        scr.setPreferredSize(new Dimension(300,100));
        scr.addActionListener(new mytxlistener());
        scr.addKeyListener(new dsads());
        c.add(scr,BorderLayout.NORTH);
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,4));
        p.setBackground(new Color(0,0,0));
        String [] nums ={"1","2","3","+","4","5","6","-","7","8"
                ,"9","*",".","0","/","="}; 
        for(int i = 0 ;i <nums.length-1;i++){
            b = new JButton(nums[i]);

            if((i+1)%4==0)b.setForeground (new Color(200,100,100));
            b.setFont(new Font("宋体",Font.BOLD,16));
            b.addActionListener(new Btlistener());
            p.add(b);
        }
            b=new JButton("=");
            b.setForeground (new Color(200,100,100));
            b.setFont(new Font("宋体",Font.BOLD,16));
            b.addActionListener(new onCaoculate());
            p.add(b);
        c.add(p,BorderLayout.CENTER);
        setVisible(true); 
    }

    class dsads implements KeyListener{
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                scr.setText(calculate(scr.getText()));}
        }
        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
        }
    }

    class mytxlistener implements ActionListener{       @Override
        public void actionPerformed(ActionEvent e) {
           String s = scr.getText();
        }
    }
    
    class onCaoculate implements ActionListener{      @Override
        public void actionPerformed(ActionEvent e) {
            scr.setText(calculate(scr.getText()));
        }
    }
   
    public String calculate(String str){

        StringBuffer inp = new StringBuffer(str);
        int _symble = 0;


        for(int i = 0 ; i < inp.length(); i++){
            if( inp.charAt(i)<= '9' && inp.charAt(i)>= '0' || inp.charAt(i) == '.'){
                continue;
            }
            else{
                _symble++;
            }
            
        }
        String [] num = new String[_symble+1];
        for(int i = 0; i< num.length; i++){
            num[i] = "";
        }
        char [] _operator = new char[_symble];
        int f=0;
        int _n = 0;
        for(int i = 0 ; i < inp.length(); i++){
            if( inp.charAt(i)<= '9' && inp.charAt(i)>= '0' || inp.charAt(i) == '.'){
                num[_n] += inp.charAt(i);
                if(inp.charAt(i)!='.')f++;
            }
            else{
                _operator[_n] = inp.charAt(i);
                _n++;
            }
        }
        if(f==0)return String.valueOf(0);


        double ans = 0;
        for(int i = 0 ; i<_symble ; i++){
            double num1 = Double.parseDouble(num[i]);
            double num2 = Double.parseDouble(num[i+1]);
            char cal = _operator[i];
            switch (cal){
                case '+':
                    ans = num1 +num2;
                    break;
                case '-':
                    ans = num1 - num2;
                    break;
                case '*':
                    ans = num1 *num2;
                    break;
                case '/':
                    ans = num1 / num2;
                    break;
                default:
                    break;
            }
            num[i+1]=String.valueOf(ans);
        }
        return String.valueOf(ans);
    }
      
    class Btlistener implements ActionListener{         @Override
        public void actionPerformed(ActionEvent e) {
                String s1 = scr.getText();
                scr.setText(s1+((JButton)e.getSource()).getText());
        }   
    }

    public static void main(String[] args){
        new Cao();
    }
}
