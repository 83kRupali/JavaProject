
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdraw1, fastCash, ministatement, pinchange, balanceq, exit;
    String pin;
    
    FastCash(String pinNumber){
        this.pin = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH)
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT:");
        //text.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.addActionListener(this);
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        
        withdraw1 = new JButton("Rs 500");
        withdraw1.addActionListener(this);
        withdraw1.setBounds(355, 415, 150, 30);
        image.add(withdraw1);
        
        fastCash = new JButton("Rs 1000");
        fastCash.addActionListener(this);
        fastCash.setBounds(170, 450, 150, 30);
        image.add(fastCash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.addActionListener(this);
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.addActionListener(this);
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        
        balanceq = new JButton("Rs 10,000");
        balanceq.addActionListener(this);
        balanceq.setBounds(355, 485, 150, 30);
        image.add(balanceq);
        
        exit = new JButton("BACK");
        exit.addActionListener(this);
        exit.setBounds(355, 520, 150, 30);
        image.add(exit);
        
        setSize(800,800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transacations(pin).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            cons c = new cons();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinNumber ='"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pin+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited successful");
                
                setVisible(false);
                new Transacations(pin).setVisible(true);
                
              }
            catch(Exception e){
                System.out.println(e); 
            }
        }
    }
   
    public static void main(String args[]) {
        new FastCash(" ");
    }
}
