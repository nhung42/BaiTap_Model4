/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2.controller;

import baitap2.DatabaseHelper;
import baitap2.model.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Bao Lam
 */
public class HoaDonController {
    private DatabaseHelper helper;

    public HoaDonController() {
        helper = new DatabaseHelper();
    }

    public ResultSet hienThiHoaDon() {
        try {
            String sql = "Select * From HoaDon";
            Statement sta = helper.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void themHoaDon(HoaDon hd) throws Exception {
        String sql = "Insert into HoaDon values(?,?,?,?,?)";
        PreparedStatement pr = helper.getConnection().prepareStatement(sql);
        pr.setString(1, hd.getMaHD());
        pr.setString(2, hd.getMaNV());
        pr.setString(3, hd.getLoaiHD());
        pr.setString(4, hd.getNgayLap());
        pr.setString(5, hd.getNgayGiao());
       
        pr.executeUpdate();
    }

    public HoaDon timKiemHoaDon(String maHD) throws Exception {
        HoaDon hd = null;
        String sql = "Select * From HoaDon Where MaHD=?";

        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maHD);
        ResultSet res = ps.executeQuery();
        if (res.next()) {
            String tenNv = res.getString("TenNV");
            String loaiHD = res.getString("LoaiHD");
            String ngayLap = res.getString("NgayLap");
            String ngayGiao = res.getString("NgayGiao");
            hd = new HoaDon(maHD, maHD, loaiHD, ngayLap, ngayGiao);
        }
        ps.close();
        res.close();
        return hd;
    }

    public void suaThongTinHoaDon(HoaDon hd) throws Exception {
        String sql = "Update HoaDon SET TenNV=?,LoaiHD=?,NgayLap=?, NgayGiao=? "
                + "Where MaHD=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);

        ps.setString(5, hd.getMaHD());
        ps.setString(1, hd.getMaNV());
        ps.setString(2, hd.getLoaiHD());
        ps.setString(3, hd.getNgayLap());
        ps.setString(4, hd.getNgayGiao());
       
        ps.executeUpdate();
    }
    
    public void xoaHoaDon(String maHD) throws Exception{
        String sql = "Delete From HoaDon Where MaHD=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maHD);
        ps.executeUpdate();
    }
}
