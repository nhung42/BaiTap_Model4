/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2.controller;

import baitap2.DatabaseHelper;
import baitap2.model.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author Bao Lam
 */
public class SanPhamController {
    private DatabaseHelper helper;

    public SanPhamController() {
        helper = new DatabaseHelper();
    }

    public ResultSet hienThiSanPham() {
        try {
            String sql = "Select * From SanPham";
            Statement sta = helper.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void themSanPham(SanPham sp) throws Exception {
        String sql = "Insert into SanPham values(?,?,?,?)";
        PreparedStatement pr = helper.getConnection().prepareStatement(sql);
        pr.setString(1, sp.getMaSP());
        pr.setString(2, sp.getTenSP());
        pr.setString(3, sp.getDonViTinh());
        pr.setString(4, sp.getGia());
       
        pr.executeUpdate();
    }

    public SanPham timKiemSanPham(String maSP) throws Exception {
        SanPham sp = null;
        String sql = "Select * From SanPham Where MaSP=?";

        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maSP);
        ResultSet res = ps.executeQuery();
        if (res.next()) {
            String tenSP = res.getString("TenSP");
            String donViTinh = res.getString("DonViTinh");
            String gia = res.getString("Gia");
            
            sp = new SanPham(maSP, tenSP, donViTinh, gia);
        }
        ps.close();
        res.close();
        return sp;
    }

    public void suaThongTinSanPham(SanPham sp) throws Exception {
        String sql = "Update SanPham SET TenSP=?,DonViTinh=?,Gia=? "
                + "Where MaSP=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);

        ps.setString(6, sp.getMaSP());
        ps.setString(1, sp.getTenSP());
        ps.setString(2, sp.getDonViTinh());
        ps.setString(3, sp.getGia());
       
        ps.executeUpdate();
    }
    
    public void xoaSanPham(String maSP) throws Exception{
        String sql = "Delete From SanPham Where MaSP=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maSP);
        ps.executeUpdate();
    }
}
