package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//public class MiniStatement extends JFrame{
    
    //*
    public class MiniStatement extends JFrame implements ActionListener{
    //*
    //*
    JButton back;
    String pinnumber;
    //*
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        
        setLayout(null);  //beacause set is not work when the setLoyout is not null;
        
        JLabel mini = new JLabel();
        
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        //*
        
         back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        add(back);
        
        //*
        try{
            cons conn = new cons();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNumber ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardNumber").substring(0,4)+"xxxxxxxx" + rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            cons conn = new cons();
            int bal =0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '"+pinnumber+"'");
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            
                    if(rs.getString("type").equals("withdraw")){
                        // bal += Integer.parseInt(rs.getString("amount"));
                          bal -= Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                          bal += Integer.parseInt(rs.getString("amount"));
                    }
            }
            
            balance.setText("Your corrent Account balance is Rs:"+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        setSize(400, 600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transacations(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new MiniStatement(" ");
    }
}