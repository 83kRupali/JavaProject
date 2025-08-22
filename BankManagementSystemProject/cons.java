
package bank.management.system;

import java.sql.*;


public class cons {
    // rigestration of the driver
    // create connection 
    // create statement
    // Excute Query
    //close connection
    
    Connection c;
    Statement s;
    
    public cons(){
        
        try{
      // Class.forName(com.myssql.cj.jdbe.Driver);
        // database name -- (user)root-- password 
        
   
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","rupali");
        s = c.createStatement();
        
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
