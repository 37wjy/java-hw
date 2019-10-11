import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ct{

    public ct(){
        JButton b=new JButton();
        JTextField text=new JTextField();
        JFrame f=new JFrame();
        Container c=f.getContentPane();
        b.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText()+"hello");
            }
        });

        c.add(text, BorderLayout.NORTH);
        c.add( b,BorderLayout.SOUTH);
        f.setDefaultCloseOperation(3);
        f.setSize(400,400);//最后
        f.setVisible(true);
    }

    public static void main(String[] args) {
        ct a=new ct();
    }
}