/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lynch
 */
public class DatabaseController {
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "root";
   static final String PASS = "";
   
   public DatabaseController(){
       init();
   }

   private void init(){
       Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
    	
            if(!databaseExist()){
                createDatabase(stmt);
            } 	
            
        }catch (Exception e){
         e.printStackTrace();
       }
   }
   
   private boolean databaseExist(){ 
       return false;
   }
   
   private void createDatabase(Statement stmt){
       try{
            String sql = "CREATE DATABASE BlackHardSweetCompany";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");  
       }catch (SQLException e){
           e.printStackTrace();
       }
   }
}