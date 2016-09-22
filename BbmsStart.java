/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbms;

import java.awt.Button;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aishwarya
 */
public class BbmsStart extends Database {

    Button b1, b2,b3,b4;
    Label l,m;
    GridBagConstraints g =new GridBagConstraints();
   
    public BbmsStart() throws IOException {
        setLayout(new GridBagLayout());
        setVisible(true);
        setSize(1000,1000);
           
        Font f = new Font("Verdana", Font.BOLD, 20);
        setFont(f);
        Color c=new Color(255, 153, 204);
        setBackground(c);
        setTitle("WELCOME TO BLOOD BANK MANAGEMENT SYSTEM");
        addWindowListener(new MyEvent());
        
        m=new Label("Blood Bank Management System");
        b1=new Button("ENTER THE DETAILS OF THE DONOR");
        b2=new Button("ENTER THE DETAILS OF BLOOD");
        b3=new Button("REQUEST BLOOD");
        b4=new Button("EXIT");
        JPanel p=new JPanel();
    ImageIcon pic2=new ImageIcon("C:\\Users\\Aishwarya Dixit\\HOME\\NetBeansProjects\\Bbms\\src\\bbms\\blood.jpg");
    p.add(new JLabel(pic2));
    g.gridx=0;
        g.gridy=0; 
        g.anchor=GridBagConstraints.WEST;
    this.add(p,g);
    g.gridx=1;
    g.gridy=0;
    g.anchor=GridBagConstraints.CENTER;
    add(m,g);
        g.gridx=1;
        g.gridy=2;
        g.ipadx=30;
        g.ipady=20;
        add(b1,g);
        
        g.gridx=1;
        g.gridy=4;
        add(b2,g);
        
        g.gridx=1;
        g.gridy=6;
        g.ipadx=20;
        add(b3,g);
        g.gridx=1;
        g.gridy=8;
        add(b4,g);
       /* BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Aishwarya Dixit\\HOME\\NetBeansProjects\\Bbms\\src\\bbms\\Derek.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        
        add(picLabel);*/
       
       JPanel panel1 = new JPanel();
    ImageIcon pic = new ImageIcon("C:\\Users\\Aishwarya Dixit\\HOME\\NetBeansProjects\\Bbms\\src\\bbms\\Derek.jpg");
    panel1.add(new JLabel(pic));
    g.gridx=2;
        g.gridy=0;
        g.gridheight=10;
        g.anchor=GridBagConstraints.EAST;
    this.add(panel1,g);
    
//b1.setBounds(10, 110, 100, 40);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(new Submit()); 
        b1.setFont(f);
       /*b1.setBounds(10, 100, 500, 40);
       b1.setForeground(Color.red);
       b1.setBackground(Color.white);*/
        //b2.setBounds(10, 400, 500, 40);
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        b2.addActionListener(new Submit2());
        b2.setFont(f);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.addActionListener(new Submit3());
        b4.setForeground(Color.black);
        b4.setBackground(Color.white);
        b4.addActionListener(new Submit4());

    }
    
    class Submit implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           
           
            Donor obj = new Donor();
            
            
        }
    }
     
    class Submit2 implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           
            String a,b,c,d;
           
            
             Bloods obj2 = new Bloods();
            
            
        }
    }
     
    class Submit3 implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            
           Request obj2 = new Request();
            
            
        }
    }
    class Submit4 implements ActionListener
              {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            
            System.exit(0);
            
        }
    }

class MyEvent extends WindowAdapter {

        public void windowClosing(WindowEvent ex) {
            System.exit(0);
        }
        
        
    }

 public static void main(String args[]) throws IOException {
             BbmsStart ob=new BbmsStart();
    }
}