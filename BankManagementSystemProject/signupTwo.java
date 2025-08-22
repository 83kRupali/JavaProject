
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener{
    JTextField pan, aadharTextField;
    JButton next;
    JRadioButton syes,sno, eno,eyes;
    JComboBox religion, category1, Occupation1, educational1,income1;
    String formno;
    
    signupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel addtionalDetail1 = new JLabel("page 2 : Addition Details");
        addtionalDetail1.setFont(new Font("Raleway", Font.BOLD, 22));
        addtionalDetail1.setBounds(290, 80, 400, 30);
        add(addtionalDetail1);
        
        JLabel religion1 = new JLabel("Relegion:");
        religion1.setFont(new Font("Raleway", Font.BOLD, 20));
        religion1.setBounds(100, 140, 100, 30);
        add(religion1);
        
        String vaiReligion[] = {"Hindu","Muslim","Sikh","Christen","Other"};
         religion = new JComboBox(vaiReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setForeground(Color.WHITE);
        add(religion);
        
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String vaiCategory[] = {"General","OBC","SC","ST","Other"};
         category1 = new JComboBox(vaiCategory);
        category1.setBounds(300, 190, 400, 30);
        category1.setForeground(Color.WHITE);
        add(category1);
        
        JLabel income= new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String vaiincome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income1= new JComboBox(vaiincome);
        income1.setBounds(300, 240, 400, 30);
        income1.setForeground(Color.WHITE);
        add(income1);
      
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 315, 200, 30);
        add(educational);
        
        String vaieducational[] = {"Non Graduation","Graduation","Post Graduation","Doctorate","Other"};
          educational1= new JComboBox(vaieducational);
        educational1.setBounds(300, 315, 400, 30);
        educational1.setForeground(Color.WHITE);
        add(educational1);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String vaiOccupation[] = {"Saleried","SelfEmpployee","Bissuness","Student","Ritered","Other"};
          Occupation1= new JComboBox(vaiOccupation);
        Occupation1.setBounds(300, 390, 400, 30);
        Occupation1.setForeground(Color.WHITE);
        add(Occupation1);
        
        JLabel panno = new JLabel("Pan no:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel Aadhar = new JLabel("Aadhar no");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar.setBounds(100, 490, 200, 30);
        add(Aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel Senior = new JLabel("Senior citizen:");
        Senior.setFont(new Font("Raleway", Font.BOLD, 20));
        Senior.setBounds(100, 540, 200, 30);
        add(Senior);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
       ButtonGroup Seniorgroup = new ButtonGroup();
       Seniorgroup.add(syes);
       Seniorgroup.add(sno);
        
        
        JLabel Existing = new JLabel("Existing Account:");
        Existing.setFont(new Font("Raleway", Font.BOLD, 20));
        Existing.setBounds(100, 590, 200, 30);
        add(Existing);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
              
       ButtonGroup Existinggroup = new ButtonGroup();
       Existinggroup.add(eyes);
       Existinggroup.add(eno);
        
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
       // next.setBounds(150,610,80,30);
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
        String sreligion = (String) religion.getSelectedItem(); 
        String scategory = (String) category1.getSelectedItem(); 
        String sincome = (String) income1.getSelectedItem(); 
        String seducational = (String) educational1.getSelectedItem(); 
        String soccupation = (String) Occupation1.getSelectedItem(); 
        String sSenior = null;
        if(syes.isSelected()){
            sSenior = "YES";
        }
        else if(sno.isSelected()){
            sSenior = "No";
        }
        
        String eExisting = null;
        if(eyes.isSelected()){
            eExisting = "YES";
        }
        else if(eno.isSelected()){
            eExisting = "No";
        }
        
        
        String panno = pan.getText();
        String aadhar = aadharTextField.getText();
    
    
    try{
            cons c = new cons();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducational+"','"+soccupation+"','"+sSenior+"','"+eExisting+"','"+panno+"','"+aadhar+"')";
            c.s.executeUpdate(query);         
        //signup object
        setVisible(false);
        new SignUpThree(formno).setVisible(true);
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    public static void main(String args[]) {
        new signupTwo("");
        // TODO code application logic here
    }
}
