
package bank.management.system;

import javax.swing.*; //Jframe in this package
import java.awt.*; //color
import java.awt.event.*; //actionlisener
import java.util.*;  //random

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
    SignUpThree(String formno){
        
        setLayout(null);
        this.formno = formno;
        
        JLabel l1 = new JLabel("Page 3: Account Detail");
        l1.setFont(new Font("Raleway", Font.BOLD, 23));
      //  l1.setBounds(280, 40, 400, 40);
        l1.setBounds(280, 40, 400, 20);
        
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
       // type.setBounds(100, 140, 200, 30);
        type.setBounds(100, 90, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
       // r1.setBounds(100, 180, 250, 20);
        r1.setBounds(100, 130, 250, 20);
        add(r1);
        
        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 130, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Recurring Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 170, 250, 20);
        add(r3);
        
        r4 = new JRadioButton("Fix Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        //r4.setBounds(350, 220, 250, 20);
        r4.setBounds(350, 170, 250, 20);
        add(r4);
        
        ButtonGroup groupAccount  = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 220, 200, 30);
        add(card);
        
         JLabel cnumber = new JLabel("xxxx-xxxx-xxxx-0184");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330, 220, 300, 30);
        add(cnumber);
        
        JLabel cardDetail = new JLabel("Your 16 Digit card number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 240, 300, 20);
        add(cardDetail);
        
       
        
        
        JLabel pin = new JLabel("Pin number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 280, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 280, 300, 30);
        add(pnumber);
       
        JLabel pinDetail = new JLabel("Your 4 Digit pin number");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 300, 300, 20);
        add(pinDetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 350, 200, 20);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway", Font.BOLD, 16));
        c1.setBounds(100, 390, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway", Font.BOLD, 16));
        c2.setBounds(350, 390, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway", Font.BOLD, 16));
        c3.setBounds(100, 440, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway", Font.BOLD, 16));
        c4.setBounds(350, 440, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway", Font.BOLD, 16));
        c5.setBounds(100, 490, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway", Font.BOLD, 16));
        c6.setBounds(350, 490, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("Above all imforamtion is right");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway", Font.BOLD, 12));
        c7.setBounds(100, 530, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("raleway", Font.BOLD, 14));
        //submit.setBounds(250, 720, 100, 30);
      //  submit.setBounds(300, 80, 100, 30);
        submit.setBounds(250, 590, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("raleway", Font.BOLD, 14));
        //cancel.setBounds(420, 720, 100, 30);
        //cancel.setBounds(400, 80, 100, 30);
        cancel.setBounds(420, 590, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Current Account";
            }
            else  if(r3.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            else  if(r4.isSelected()){
                accountType = "Fix Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = " " +Math.abs((random.nextLong() % 90000000L) * 504093600000000L);
            
            String pinNumber = " " + Math.abs((random.nextLong()% 9000L)+1000L); 
            
            String facility = " ";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }
            
            else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if(c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            }
            else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if(accountType.equals(" ")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }
                else {
                    cons conn = new cons();
                    String query1 = "insert signUpTree value('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinNumber+"','"+facility+"')";
                    
                    String query2 = "insert login value('"+formno+"','"+cardnumber+"','"+pinNumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber + "\n Pin Number: "+pinNumber);
                
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignUpThree(" ");
    }
}
