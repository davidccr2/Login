/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DAVID
 */
public class conexion {
    String bd="logindc";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String pw="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection dc;
    
    public conexion(){
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            dc=DriverManager.getConnection(url+bd,user,pw);
            System.out.println("se conecto a bd");
        } catch (ClassNotFoundException | SQLException ex) {
             System.out.println("No se Conecto a bd"+ dc);
//            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return dc;
    }
    
    public void desconectar(){
        try {
            dc.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PreparedStatement prepareStatement(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
