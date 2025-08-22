package bank.management.system;

import javax.swing.*;  //Jframe in this package
import java.awt.*;  //color
import java.awt.event.*; //actionlisener
import java.sql.*;

/*
GDBC : Java Database Connectivity, commonly referred to as JDBC
istablish the connection using create the object
*/

public class Login extends JFrame implements ActionListener{ 
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setTitle("ATM MACHINE");
        setLayout(null); //sift left side
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,30));
         //text.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD,30));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,30));
        pin.setBounds(120, 220, 400, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
         login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK );
        login.setForeground(Color.WHITE );
        login.addActionListener(this);
        add(login);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK );
        clear.setForeground(Color.WHITE );
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK );
        signup.setForeground(Color.WHITE );
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText(" ");
            pinTextField.setText(" ");
        }
        else if(ae.getSource() == login){
           cons conn = new cons();
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText();
           String query = "select * from login where cardNumber = '"+cardnumber+"' and pinNumber = '"+pinnumber+"'";
           
           try{
              ResultSet rs = conn.s.executeQuery(query);//stored the data
              
            if(rs.next()){
                setVisible(false);
                new Transacations(pinnumber).setVisible(true); 
                }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect card Number or pin");
            }
           }
           catch(Exception e){
               System.out.println(e);               
           }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new signupone().setVisible(true);
            
        }
        
    }

    public static void main(String args[]) {
       new Login();
       
    }
}
