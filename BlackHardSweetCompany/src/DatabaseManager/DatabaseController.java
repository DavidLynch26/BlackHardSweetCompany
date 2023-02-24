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
    private static final String[] tableNames = {"Driver", "Customer", "Admin", "Inventory"};
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB_NAME = "BlackHardSweetCompany";

    public DatabaseController(){
        init();
    }

    private void init(){
        Statement stmt = setConnection();
        createDatabase(stmt);
 //       createTables(stmt);
    }

    public void createTbles(Statement stmt){

 //       stmt.close();
    }

    private void drop(){
        try {
            Statement stmt = setConnection();
            String sql = "Drop Database " + getDB_NAME();
            stmt.executeUpdate(sql);
            System.out.println(getDB_NAME()+ " dropped successfully...");  
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Statement setConnection(){
        Connection conn = null;
        Statement stmt = null;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());
             stmt = conn.createStatement();
         }catch (Exception e){
          e.printStackTrace();
         }
         return stmt;
    }

    private void createDatabase(Statement stmt){
        try{
             String sql = "CREATE DATABASE " + getDB_NAME();
             stmt.executeUpdate(sql);
             System.out.println(getDB_NAME()+ " created successfully...");  
             stmt.close();
        }catch (SQLException e){
            if(e.getErrorCode() == 1007){
                System.out.println(e.getMessage());
            }else{
                e.printStackTrace();
            }
        }
    }
     public static String getDB_URL() {
         return DB_URL;
     }

     public static String getUSER() {
         return USER;
     }

     public static String getPASS() {
         return PASS;
     }

     public static String getDB_NAME() {
         return DB_NAME;
     }
}