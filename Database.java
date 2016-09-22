/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbms;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aishwarya
 */
public class Database extends Frame {
   
    Connection con,con2;
    PreparedStatement ps,ps2,ps3,ps4;
    ResultSet rs,rs2;
    
    String img_name;

public Database()
{
	try
	{
            //System.out.print("hello!!");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BBMS","root","@idx");
      
      
    }catch(SQLException sqe){
	System.out.println("Could not connect to database");
    }

}
    

public void storeDonor(String name,String age,String gender,String address,String contact)
{
	try
	{
   
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/BBMS","root","@idx");
           PreparedStatement stmt = con.prepareStatement("insert into DonorDetails(name,age,gender,address,contact) values(?,?,?,?,?)");
           
           stmt.setString(1, name);
           stmt.setString(2, age);
           stmt.setString(3, gender);
           stmt.setString(4, address);
           stmt.setString(5, contact);
          //stmt.executeUpdate("insert into BloodDetails(bg,platelet,wbc,rbc,vol,packtype,doe) values(\"test\",10,10,10,10,\"test\",now())");
           stmt.execute();
                  
    con.close();
    }catch(Exception e)
    {
	 System.out.println("File not found or sql exception");
	}
}




public void storeBlood(String bg,String packtype,String platelet,String wbc,String rbc,String vol)
{
	try
	{
   
           //Class.forName(com.mysql.jdbc.Driver);
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/BBMS","root","@idx");
           PreparedStatement stmt = con.prepareStatement("insert into BloodDetails(bg,platelet,wbc,rbc,vol,packtype,date) values(?,?,?,?,?,?,now())");
          stmt.setString(1, bg);
          stmt.setString(2, platelet);
          stmt.setString(3, wbc);
          stmt.setString(4, rbc);
          stmt.setString(5, vol);
          stmt.setString(6, packtype);
          stmt.execute();
                  
con.close();
    }catch(Exception e)
    {
	e.printStackTrace(); 
        System.out.println("File not found or sql exception");
	}
}




public ResultSet retrieveBlood(String bg)
{
    try{
    ps = con.prepareStatement("select * from BloodDetails where bg = ?");

    ps.setString(1, bg);
    rs = ps.executeQuery();//System.out.println(rs);
    return rs;
   
    }catch(Exception e){System.out.println("Sql exception");}
		return null;
}



public ResultSet retrieveDonor(int packid)
{
    try{
    ps2 = con.prepareStatement("select * from DonorDetails where packid = ?");

    ps2.setInt(1, packid);
    rs2 = ps2.executeQuery();
    return rs2;
    
    }catch(Exception e){System.out.println("Sql exception in rs2");}
		return null;
}

public void remove(String bloodgrp) 
{
    try
    {
    ps3=con.prepareStatement("delete from BloodDetails where bg = bloodgrp");
    }catch(Exception e){System.out.println("SqlException");}
}
public void display(String bg)
{
    
        Database obj = new Database();
        
        ResultSet rs=obj.retrieveBlood(bg);
        int r=0;
        
        JFrame frame=new JFrame("MATCHED RESULTS");
        //frame.setLayout(new GridLayout(3,12));
        //frame.setLayout(new FlowLayout());
        frame.setSize(500,700);
        setSize(900, 500);
        setBackground(Color.cyan);
         Font font = new Font("Helvetica", Font.BOLD,14);
        try{
        while(rs.next())
        {
            
             JLabel lb[]=new JLabel[12];
             String g=rs.getString("bg");
             lb[0]=new JLabel();
             lb[1]=new JLabel();
             lb[2]=new JLabel();
             lb[3]=new JLabel();
             lb[4]=new JLabel();
             lb[5]=new JLabel();
             lb[6]=new JLabel();
             lb[7]=new JLabel();
             lb[8]=new JLabel();
             lb[9]=new JLabel();
             lb[10]=new JLabel();
             lb[11]=new JLabel();
             
             lb[0].setText(g);
             String g2=rs.getString("platelet");
             System.out.println("g2 is "+g2);
             lb[1].setText(g2);
             String g3=rs.getString("wbc");
             System.out.println("g2 is "+g3);
             lb[2].setText(g3);
             String g4=rs.getString("rbc");             
             lb[3].setText(g4);
             
              String g5=rs.getString("vol");
             lb[4].setText(g5);
              String g6=rs.getString("packtype");
             lb[5].setText(g6);
              String g7=rs.getString("date");
             lb[6].setText(g7);
            
             ResultSet rs2=obj.retrieveDonor(rs.getInt("packid"));
              while(rs2.next())
              {
              String g8=rs2.getString("name");System.out.println("name is "+g8);
             lb[7].setText(g8);
             System.out.println("No error till here \n g is "+g);
              String g9=rs2.getString("age");
             lb[8].setText(g9);
              String g10=rs2.getString("gender");
             lb[9].setText(g10);
              String g11=rs2.getString("address");
             lb[10].setText(g11);
             String g12=rs2.getString("contact");
             lb[11].setText(g12);
              }
             
             
              for(int i=0;i<=11;i++)
              {lb[i].setForeground(Color.blue);
              lb[i].setFont(font);
              }
             frame.add(lb[0]);
             frame.add(lb[1]);            
             frame.add(lb[2]);
             frame.add(lb[3]);
             frame.add(lb[4]);
             frame.add(lb[5]);
             frame.add(lb[6]);
             frame.add(lb[7]);
             frame.add(lb[8]);
             frame.add(lb[9]);
             frame.add(lb[10]);
             frame.add(lb[11]);
             r++;
            
        }
        
        frame.setLayout(new GridLayout(r,12));
        
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        }catch(Exception e){e.printStackTrace();}
    
    
    
    
    
    
    
    
    
}
public static void main(String args[])throws IOException
        
{
    Database obj=new Database();
}



}
