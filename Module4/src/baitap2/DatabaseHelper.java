/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2;

import baitap1.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bao Lam
 */
public class DatabaseHelper {

    private Connection con=null;
    private Statement sta=null;

    private String url = "jdbc:derby://localhost:1527/BaiTap2";
    private String user = "Nhung1";
    private String pass = "123";

    public DatabaseHelper() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con =(Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("ket noi thanh cong");
        } catch (Exception ex) {
            System.out.println("ket noi that bai" + ex.toString());
        }
    }

    public void doSQL(String sql) {
        try {
            sta = con.createStatement();
            sta.execute(sql);
            System.out.println("Thực thi thành công");
        } catch (SQLException ex) {
            
        }
    }

    public Connection getConnection() {
        return con;
    }
}