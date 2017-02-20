/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.genererpdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class MyConnectio {
    
    String url="jdbc:mysql://localhost:3306/piuniversity";
    String username="root";
    String password="";
    static Connection connection;
    
    private MyConnectio() {
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("connex etablie");
                
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
                    
            
    
}
}