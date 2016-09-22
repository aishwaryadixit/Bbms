/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbms;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aishwarya
 */
public class Request extends Database {

    Button b1, b2,b3;
    Label l;
    TextField bg;
    public Request() {
        setVisible(true);
        setSize(550, 500);
         Color c=new Color(255, 153, 204);
        setBackground(c);
        setLayout(null);
        Font f = new Font("Verdana", Font.BOLD, 20);
        setFont(f);
        setTitle("REQUEST FOR BLOOD");
        addWindowListener(new MyEvent() {
        });
        Label l0=new Label("Enter the required bloodgroup");
        Label l1 = new Label("Bloodgroup:");
       
        
        bg = new TextField(20);
        
        
        
        b1 = new Button("Search for matches");
        b2 = new Button("Back");
        b3 = new Button("Remove from the bank");
        add(l0);
        add(l1);
        add(bg);
        add(b1);      
        add(b2);
        add(b3);
        l0.setBounds(10,20,400,40);
        l1.setBounds(10, 80, 140, 40);
        bg.setBounds(200, 90, 110, 40);
        b1.setBounds(10, 140, 400, 40);
       
        b1.setForeground(Color.red);
        b1.setBackground(Color.white);

        b1.addActionListener(new Submit());    
         b2.setBounds(10, 190, 200, 40);
         b3.setBounds(250,190,250,40);
        b2.setForeground(Color.red);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b3.setForeground(Color.red);

        b2.addActionListener(new Submit2()); 
        b3.addActionListener(new Submit3());
      

    }
    class Submit implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          
            String bg1 = bg.getText();
            
           
            
            display(bg1);
            System.out.println("submit is pressed 1");
            
            
        }
    }
    class Submit2 implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            try {
                BbmsStart ob=new BbmsStart();
            } catch (IOException ex) {
                
            }
        
            
        }
    }
class Submit3 implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        String bg1=bg.getText();
        remove(bg);
        System.out.println("removed the user's entry from the inventory");
    }
}
    class MyEvent extends WindowAdapter {

        public void windowClosing(WindowEvent ex) {
            System.exit(0);
        }
    }

  

    public static void main(String args[]) {
        Request b = new Request();
       
    }

}
