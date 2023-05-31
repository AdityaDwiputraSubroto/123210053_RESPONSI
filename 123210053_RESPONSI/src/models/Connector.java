/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.*;
/**
 *
 * @author Lab Informatika
 */
public class Connector {
    private String dbUrl = "jdbc:mysql://localhost:3306/movie_db";
    private String dbUsername = "root";
    private String dbPassword = "";
    private Connection connection;
    
    public Connector() {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection)DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
    }catch(Exception e){
       // System.PrintoutLn();
       System.out.println("Koneksi gagal"+e.getMessage());
       e.printStackTrace();
    }
    }
    
    public Connection getConnection(){
        return connection;
    }
            
    
}
