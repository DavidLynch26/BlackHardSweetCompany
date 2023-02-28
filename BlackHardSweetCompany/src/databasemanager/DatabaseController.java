/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lynch
 */
public class DatabaseController {
    private static final String[] baseData= {"(id INTEGER not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "username VARCHAR(255),"
            + "password VARCHAR(255),"
            + "PRIMARY KEY(id))",
        
            "(id INTEGER not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "username VARCHAR(255),"
            + "password VARCHAR(255),"
            + "PRIMARY KEY(id))",
            
            "(id INTEGER not null,"
            + "firstname VARCHAR(255),"
            + "lastname VARCHAR(255),"
            + "address VARCHAR(255),"
            + "PRIMARY KEY(id))",
            
            "(id VARCHAR(255),"
            + "item VARCHAR(255),"
            + "price DECIMAL(65),"
            + "PRIMARY KEY(id))", 
            
            "(id INTEGER not null ,"
            + "itemid VARCHAR(255),"
            + "custid INTEGER,"
            + "price DECIMAL(65),"
            + "PRIMARY KEY(id))"};
    
    private static final String[] tableNames = {"Admin", "Driver", "Customer", "Inventory", "CustOrder"};
    private static final String DB_URL = "jdbc:mysql://localhost/" + getDB_NAME();
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB_NAME = "BlackHardSweetCompany";

    public DatabaseController(){
        init();
    }

    private void init(){
        Statement stmt = setConnection();
//        drop(tableNames, "TABLE ");
        createDatabase(stmt);
        createTables(stmt);
    }

    private void createTables(Statement stmt){
        Integer count = 0;
        for(String table: getTableNames()){
            try {
                String sql = "CREATE TABLE " + table + baseData[count];
//                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println(table + " created successfully...");
                
            } catch (SQLException e) {
                if(e.getErrorCode() == 1050){
                    System.out.println(e.getMessage());
                }else{
                    e.printStackTrace();
                }              
            }
            count++;
        }
    }

    private void drop(String[] names, String type){
        for(String name: names){
            try {
                Statement stmt = setConnection();
                String sql = "Drop " + type + name;
                stmt.executeUpdate(sql);
                System.out.println(name + " dropped successfully...");  
                stmt.close();
            } catch (SQLException e) {
                if(e.getErrorCode() == 3702){
                    System.out.println(e.getMessage());
                }else{
                    e.printStackTrace();
                }        
            }
        }
    }

    private Statement setConnection(){
        Statement stmt = null;
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());
           stmt = conn.createStatement();
           return stmt;
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
    public static String[] getTableNames() {
       return tableNames;
    }
}