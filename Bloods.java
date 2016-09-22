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
public class Bloods extends Database {

    Button b1, b2;
    Label l;
    String bg1;
    
    TextField bg, platelet, wbc, rbc, volume,packtype,date;
    CheckboxGroup gen=new CheckboxGroup();
     Bloods() {
        setVisible(true);
        setSize(800,800);
         Color c=new Color(255, 153, 204);
        setBackground(c);
        setLayout(null);
        Font f = new Font("Verdana", Font.BOLD, 20);
        setFont(f);
        setTitle("BLOOD DETAILS");
        addWindowListener(new MyEvent() {
        });
        Label l0=new Label("Enter the blood details");
        Label l1 = new Label("Bloodgroup:");
        Label l2 = new Label("Platelets:");
        Label l3 = new Label("WBCs:");
        Label l4 = new Label("RBCs:");
        Label l5 = new Label("Volume:");
        Label l6 = new Label("Pack Type:");
        //Label l7 = new Label("Date:");
        
        bg = new TextField(20);
        platelet = new TextField(20);
        wbc= new TextField(20);
        rbc = new TextField(20);
        volume = new TextField(20);
        packtype = new TextField(20);
       
        b1 = new Button("Submit");
        b2 = new Button("Back");
        add(l0);
        add(l1);
        add(bg);
        add(l2);
        add(platelet);
        add(l3);
        add(wbc);        
        add(l4);
        add(rbc);
        add(l5);
        add(volume);
        add(l6);
        add(packtype);
        //add(l7);
        add(b1);        
        add(b2);
        l0.setBounds(210,20,400,40);
        l1.setBounds(210, 80, 140, 40);
        bg.setBounds(400, 90, 110, 20);
        l2.setBounds(210, 140, 140, 80);
        platelet.setBounds(400, 170, 110, 20);
        l3.setBounds(210, 220, 140, 80);
        wbc.setBounds(400, 250, 110, 20);
        l4.setBounds(210, 290, 140, 80);
        rbc.setBounds(400, 320, 110, 20);
        l5.setBounds(210, 370, 140, 80);
        volume.setBounds(400, 400, 110, 20);
        l6.setBounds(210, 450, 140, 80);
        packtype.setBounds(400, 480, 110, 20);
      
      
       b1.setBounds(210, 610, 100, 40);
          b1.setForeground(Color.red);
       b1.setBackground(Color.white);
        b1.addActionListener(new Submit()); 
        b2.setBounds(350, 610, 100, 40);
          b2.setForeground(Color.red);
       b2.setBackground(Color.white);
        b2.addActionListener(new Submit2());
        
      

    }
    class Submit implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          
            String bg1 = bg.getText();
            String a,b,c,d;
            a=packtype.getText();b=platelet.getText();
            c=wbc.getText();d=rbc.getText();String v=volume.getText();
           
            
            storeBlood(bg1,a,b,c,d,v);
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

    class MyEvent extends WindowAdapter {

        public void windowClosing(WindowEvent ex) {
            System.exit(0);
        }
    }

  

    public static void main(String args[]) {
        Bloods b = new Bloods();
        Database o = new Database();
       
    }

}
