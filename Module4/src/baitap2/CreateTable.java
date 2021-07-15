/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2;

/**
 *
 * @author duong nhung
 */
public class CreateTable {
    DatabaseHelper helper = new DatabaseHelper();

    public void createTable(){
        createTable_NhanVien();
        createTable_SanPham();
        createTable_HoaDon();
    }
    
    public void createTable_NhanVien(){
        String sql = "Create table NhanVien("
                + "MaNV varchar(10) PRIMARY KEY,"
                + "HoTen varchar(50),"
                + "NgaySinh varchar(50),"
                + "DiaChi varchar(50),"
                + "SoDT varchar(50),"
                + "GioiTinh varchar(10)"
                + ")";
        helper.doSQL(sql);
    }
    
    public void createTable_SanPham(){
        String sql = "Create table SanPham("
                + "MaSP varchar(10) PRIMARY KEY,"
                + "TenSP varchar(50),"
                + "DonViTinh varchar(50),"
                + "Gia varchar(50)"
                + ")";
        helper.doSQL(sql);
    }
    
    public void createTable_HoaDon(){
        String sql = "Create table HoaDon("
                + "MaHD varchar(10) PRIMARY KEY,"
                + "TenNV varchar(50),"
                + "LoaiHD varchar(50),"
                + "NgayLap varchar(50),"
                + "NgayGiao varchar(50)"
                + ")";
        helper.doSQL(sql);
    }
}
