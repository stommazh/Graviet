/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static String account_table = "account";
    private static String account_id = "account_id";
    private static String account_email = "email";
    private static String account_password = "password";

    public static boolean checkEmail(String email) {
        boolean st = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            PreparedStatement ps = con.prepareStatement("select " + account_email + " from " + account_table + " where " + account_email + "=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            st = rs.next();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return st;
    }

    public static boolean checkUser(String email, String password) {
        boolean st = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            PreparedStatement ps = con.prepareStatement("select " + account_email + "," + account_password + " from " + account_table + " where (email=? and password= ? )");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return st;
    }

    public static String getUserID(String email) {
        String id = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            PreparedStatement ps = con.prepareStatement("select " + account_id + " from " + account_table + " where " + account_email + " = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                id = rs.getString(account_id);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static void addUser(String email, String password){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/graviet", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into account (email, password) values (?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            
            con.close();
         
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        
    }

}
