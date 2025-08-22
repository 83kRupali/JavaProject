
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transacations extends JFrame implements ActionListener{
    
    JButton deposit, withdraw1, fastCash, ministatement, pinchange, balanceq, exit;
    String pin;
    
    Transacations(String pinNumber){
        this.pin = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH)
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        //text.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        
        withdraw1 = new JButton("Cash Withdraw");
        withdraw1.addActionListener(this);
        withdraw1.setBounds(355, 415, 150, 30);
        image.add(withdraw1);
        
        fastCash = new JButton("Fast Cash");
        fastCash.addActionListener(this);
        fastCash.setBounds(170, 450, 150, 30);
        image.add(fastCash);
        
        ministatement = new JButton("Mini statement");
        ministatement.addActionListener(this);
        ministatement.setBounds(355, 450, 150, 30);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.addActionListener(this);
        pinchange.setBounds(170, 485, 150, 30);
        image.add(pinchange);
        
        balanceq = new JButton("Balance Enquiry");
        balanceq.addActionListener(this);
        balanceq.setBounds(355, 485, 150, 30);
        image.add(balanceq);
        
        exit = new JButton("EXITS");
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
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource() == withdraw1){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource() == balanceq){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource() == ministatement){
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transacations(" ");
    }
}
