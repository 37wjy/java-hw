


//import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Cao extends JFrame {
    private JTextField t1;
    //private JTextArea  t2;
    private JButton    b;
    public Cao(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,600);
        Container c = getContentPane();
        c.setBackground(new Color(255,255,255));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,5,5,5));
        p1.setBackground(new Color(255,255,255));
        //p.setBounds(50,50,300,500);
        String [] nums ={"1","2","3","+","-","4","5","6","*","/","7","8"
                ,"9","0","."}; 
        for(int i = 0 ;i <nums.length;i++){
            b = new JButton(nums[i]);
            b.addActionListener(new OkButtonlistener());
            p1.add(b);
        }
        c.add(p1,BorderLayout.CENTER);
        JPanel p2 = new JPanel();
        JButton b1 = new JButton("=");
        b1.addActionListener(new calculationListener() );
        p2.add(b1);
        c.add(p2,BorderLayout.SOUTH);
        
        //b =new JButton("点我呀");
        //b.addActionListener(new OkButtonlistener());
        //c.add(b,BorderLayout.EAST);
        t1 =  new JTextField();
        t1.addActionListener(new mytxlistener());
        c.add(t1,BorderLayout.NORTH);
        //t2 = new JTextArea("");
        //c.add(t2,BorderLayout.CENTER);
        setVisible(true); 
        
    }
    
    class calculationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setText(calculate(t1.getText()));
        }
        
        
    }
//    
    public String calculate(String str){
        StringBuffer bf = new StringBuffer(str);
        
        int count2 = 0;
        for(int i = 0 ; i < bf.length(); i++){
            if( bf.charAt(i)<= '9' 
                    && bf.charAt(i)>= '0' || bf.charAt(i) == '.'){
                
                continue;
            }
            else{
                count2++;
            }
            
        }
        String [] num = new String[count2+1];
        for(int i = 0; i< num.length; i++){
            num[i] = "";
        }
        char [] ope   = new char[count2];
        int si = 0;
        for(int i = 0 ; i < bf.length(); i++){
            if( bf.charAt(i)<= '9' 
                    && bf.charAt(i)>= '0' || bf.charAt(i) == '.'){
                num[si] += bf.charAt(i);
            }
            else{
                ope[si] = bf.charAt(i);
                si++;
            }
        }
        double res = 0;
        for(int i = 0 ; i<count2 ; i++){
            double num1 = Double.parseDouble(num[i]);
            double num2 = Double.parseDouble(num[i+1]);
            char cal = ope[i];
            switch (cal){
                case '+':
                    res = num1 +num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 *num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                default:
                    break;
            }
            num[i+1]=String.valueOf(res);
        }
        return String.valueOf(res);
    }
    
    
    
    
    
    class mytxlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String s = t1.getText();
           //t2.setText(t2.getText() + s);
        }
        
    }
    
    class OkButtonlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
                String s1 = t1.getText();
                t1.setText(s1+((JButton)e.getSource()).getText());
              
        }
            
        
    }
    
    
    public static void main(String[] args){
        new Cao();
    }
}
