import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * draw
 */
public class draw {

    public static void main(String[] args) {
        JFrame iframe=new JFrame();
        Container iContainer=iframe.getContentPane();//注意！
        JPanel iPanel=new JPanel();
        JButton iButton=new JButton("b1");
        JTextField iTextArea = new JTextField();
        iframe.setSize(400,400);
        iframe.setDefaultCloseOperation(3);

        iButton.addActionListener(new ActionListener(){
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                iTextArea.setText(String.valueOf(i++));
            }
        });


        for (int i = 0; i < 2; i++) {
            JButton jb=new JButton("xx");
            jb.addActionListener(new ActionListener(){
                int i=0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    iTextArea.setText(String.valueOf(i++));
                }
            });
            iPanel.add(jb);
        }
        
        iContainer.add(iPanel,BorderLayout.SOUTH);
        iContainer.add(iButton, BorderLayout.CENTER);
        iContainer.add(iTextArea, BorderLayout.NORTH);
        

        iframe.setVisible(true);
    }
}