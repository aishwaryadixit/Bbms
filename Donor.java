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
public class Donor extends Database {

    Button b1, b2;
    Label l;
    TextField name, age, gender, addr, cont;
    CheckboxGroup gen=new CheckboxGroup();
    public Donor() {
        DonorD();
    }
    public void DonorD()
    {
        
        //Image img = Toolkit.getDefaultToolkit().createImage("/home/aishwarya/bc.jpg");
        
        setVisible(true);
        setSize(800, 800);
         Color c=new Color(255, 153, 204);
        setBackground(c);
        setLayout(null);
        Font f = new Font("Verdana", Font.BOLD, 20);
        setFont(f);
        setTitle("DONOR DETAILS");
        addWindowListener(new MyEvent() {
        });
        Label l0=new Label("Enter the donor details");
        Label l1 = new Label("Name:");
        Label l2 = new Label("Age:");
        Label l3 = new Label("Gender:");
        Label l4 = new Label("Contact:");
        Label l5 = new Label("Address:");
        Checkbox male=new Checkbox("Male",gen,true);//not working  
        Checkbox female=new Checkbox("Female",gen,false);
        Checkbox other=new Checkbox("Other",gen,false);
        name = new TextField(20);
        age = new TextField(20);
        gender = new TextField(20);
        addr = new TextField(20);
        cont = new TextField(20);
        b1 = new Button("Submit");
        b2 = new Button("Back");

        add(l0);
        add(l1);
        add(name);
        add(l2);
        add(age);
        add(l3);
        add(gender);        
        add(l4);
        add(addr);
        add(l5);
        add(cont);
        add(b1);
        add(b2);
        
        add(male);
        add(female);
        add(other);
        
        l0.setBounds(210,20,400,40);
        l1.setBounds(210, 80, 90, 80);
        name.setBounds(400, 80, 110, 40);
        l2.setBounds(210, 150, 90, 80);
        age.setBounds(400, 150, 110, 40);
        l3.setBounds(210, 220, 90, 80);
        gender.setBounds(400, 220, 110, 40);
        l4.setBounds(210, 290, 90, 80);
        addr.setBounds(400, 290, 110, 40);
        l5.setBounds(210, 370, 90, 80);
        cont.setBounds(400, 370, 110, 40);
        b1.setBounds(210, 450, 100, 40);
       b1.setForeground(Color.red);
       b1.setBackground(Color.white);
       b2.setBounds(350, 450, 100, 40);
       b2.setForeground(Color.red);
       b2.setBackground(Color.white);
       
      

    

    
    b1.addActionListener(new Submit());   
    b2.addActionListener(new Submit2());
      

    }
    class Submit implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           // if (e.getSource() == b1)
            //{String
            String a,b,c,d;
            a=name.getText();b=age.getText();
            d=addr.getText();c=gender.getText();String v=cont.getText();
            storeDonor(a,b,c,d,v);
            System.out.println("submit is pressed");
           
            
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
        Donor d = new Donor();
             
        Database o = new Database();
        
    }

}
