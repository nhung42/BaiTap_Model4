/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2.controller;

import baitap2.DatabaseHelper;
import baitap2.model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author duong nhung
 */
public class NhanVienController {

    private DatabaseHelper helper;

    public NhanVienController() {
        helper = new DatabaseHelper();
    }

    public ResultSet hienThiNhanVien() {
        try {
            String sql = "Select * From NhanVien";
            Statement sta = helper.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void themNhanVien(NhanVien nv) throws Exception {
        String sql = "Insert into NhanVien values(?,?,?,?,?,?)";
        PreparedStatement pr = helper.getConnection().prepareStatement(sql);
        pr.setString(1, nv.getMaNV());
        pr.setString(2, nv.getHoTen());
        pr.setString(3, nv.getNgaySinh());
        pr.setString(4, nv.getDiaChi());
        pr.setString(5, nv.getSoDT());
        pr.setString(6, nv.getGioiTinh());

        pr.executeUpdate();
    }

    public NhanVien timKiemNhanVien(String maNV) throws Exception {
        NhanVien nv = null;
        String sql = "Select * From NhanVien Where MaNV=?";

        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maNV);
        ResultSet res = ps.executeQuery();
        if (res.next()) {
            String hoTen = res.getString("HoTen");
            String ngaySinh = res.getString("NgaySinh");
            String diaChi = res.getString("DiaChi");
            String soDT = res.getString("SoDT");
            String gioiTinh = res.getString("GioiTinh");
            nv = new NhanVien(maNV, hoTen, ngaySinh, diaChi, soDT, gioiTinh);
        }
        ps.close();
        res.close();
        return nv;
    }

    public void suaThongTinNhanVien(NhanVien nv) throws Exception {
        String sql = "Update NhanVien SET HoTen=?,NgaySinh=?,DiaChi=?,SoDT=?,GioiTinh=? "
                + "Where MaNV=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);

        ps.setString(6, nv.getMaNV());
        ps.setString(1, nv.getHoTen());
        ps.setString(2, nv.getNgaySinh());
        ps.setString(3, nv.getDiaChi());
        ps.setString(4, nv.getSoDT());
        ps.setString(5, nv.getGioiTinh());

        ps.executeUpdate();
    }
    
    public void xoaNhanVien(String maNV) throws Exception{
        String sql = "Delete From NhanVien Where MaNV=?";
        PreparedStatement ps = helper.getConnection().prepareStatement(sql);
        ps.setString(1, maNV);
        ps.executeUpdate();
    }
}
