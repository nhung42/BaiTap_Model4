/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap3;

import baitap1.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author duong nhung
 */
public class DatabaseController {
    private DatabaseHelper helper;

    public DatabaseController() {
        helper = new DatabaseHelper();
    }
    
    public ResultSet hienThiSanPham(){
        try {
            String sql = "Select * From SanPham s "
                    + "INNER JOIN LoaiSanPham l ON s.MaLoaiSP = l.MaLoaiSP";
            Statement sta = helper.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void themLoaiSanPham(LoaiSanPham loaiSP) throws Exception{
        String sql = "Insert into LoaiSanPham values(?,?)";
        PreparedStatement pr = helper.getConnection().prepareStatement(sql);
        pr.setString(1, loaiSP.getMaLoaiSP());
        pr.setString(2, loaiSP.getTenLoaiSP());
        
        pr.executeUpdate();
    }
    
    public void themSanPham(SanPham sp, LoaiSanPham loaiSP) throws Exception{
        String sql = "Insert into SanPham values(?,?,?,"
                + "(SELECT MaLoaiSP From LoaiSanPham Where MaLoaiSP=?))";
        PreparedStatement pr = helper.getConnection().prepareStatement(sql);
        pr.setString(1, sp.getMaSP());
        pr.setString(2, sp.getTenSP());
        pr.setString(3, sp.getNhaSanXuat());
        pr.setString(4, loaiSP.getMaLoaiSP());
        
        pr.executeUpdate();
    }
}
