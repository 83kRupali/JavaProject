
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signupone extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,fmale, maried,unmaried,other1;
    JDateChooser dateChooser;
    signupone(){
        
        setLayout(null);
        
        Random ran = new Random();
        System.out.println(ran);
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO:"+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetail1 = new JLabel("page 1 : Personal Details");
        personDetail1.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetail1.setBounds(290, 80, 400, 30);
        add(personDetail1);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel FatherName = new JLabel("Father Name:");
        FatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        FatherName.setBounds(100, 190, 200, 30);
        add(FatherName);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
         JLabel dob = new JLabel("Date of birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser(); 
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
       
        JLabel gender = new JLabel("gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        fmale = new JRadioButton("Female");
        fmale.setBounds(450,290,120,30);
        fmale.setBackground(Color.WHITE);
        add(fmale);
       
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(fmale);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Stetus:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        maried = new JRadioButton("Maried");
        maried.setBounds(300,390,100,30);
        maried.setBackground(Color.WHITE);
        add(maried);
        
        unmaried = new JRadioButton("Unmaried");
        unmaried.setBounds(450,390,100,30);
        unmaried.setBackground(Color.WHITE);
        add(unmaried);
        
        other1 = new JRadioButton("Other");
        other1.setBounds(630,390,120,30);
        other1.setBackground(Color.WHITE);
        add(other1);
       
        ButtonGroup mGroup = new ButtonGroup();
        mGroup.add(maried);
        mGroup.add(unmaried);
        mGroup.add(other1);
        
        JLabel add = new JLabel("Address:");
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBounds(100, 440, 200, 30);
        add(add);
        
        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addTextField.setBounds(300, 440, 400, 30);
        add(addTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pin = new JLabel("pin code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
       // next.setBounds(150,610,80,30);
     //  next.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        next.setBounds(600, 630, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
      //  setSize(900, 850);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = " " +random;
        String name = nameTextField.getText(); //settext
        String fname = fnameTextField.getText(); //settext
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); //settext
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(fmale.isSelected()){
            gender = "Female";
        }
        
        String  email = emailTextField.getText();
        
        String marital = null;
        if(maried.isSelected()){
            marital = "Married";
        }
        else if(unmaried.isSelected()){
            marital = "UnMarried";
        }
        else if(other1.isSelected()){
            marital = "Other";
        }
        
        String add = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
    
    
    try{
        if(name.equals(" ")){
            JOptionPane.showMessageDialog(null, "Name is requied");
        }
        
        else{
            cons c = new cons();
            String query = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+add+"','"+marital+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);  
            setVisible(false);
            new signupTwo(formno).setVisible(true);
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    public static void main(String args[]) {
        new signupone();
        // TODO code application logic here
    }
}
