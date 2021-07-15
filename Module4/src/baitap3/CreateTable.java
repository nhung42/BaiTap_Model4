/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap3;

import baitap1.*;

/**
 *
 * @author duong nhung
 */
public class CreateTable {
    private DatabaseHelper helper;

    public CreateTable() {
        helper = new DatabaseHelper();
    }

    public void createTable_TacGia() {
        String sql = "CREATE TABLE TacGia("
                + "MaTG varchar(5) PRIMARY KEY,"
                + "TenTG varchar(30),"
                + "DCLienHe varchar(100)"
                + ")";
        helper.doSQL(sql);
    }
    
    public void createTable_Sach() {
        String sql = "CREATE TABLE Sach("
                + "MaSach varchar(5) PRIMARY KEY,"
                + "TuaSach varchar(50),"
                + "SoTrang smallint,"
                + "MaTG varchar(5),"
                + "NamXB int,"
                + "TuKhoa varchar(20),"
                + "NXB varchar(50),"
                + "FOREIGN KEY (MaTG) REFERENCES TacGia(MaTG)"
                + ")";
        helper.doSQL(sql);
    }
        public void createTable_ChiTietSach() {
        String sql = "CREATE TABLE ChiTietSach("
                + "MaCaBiet varchar(10) PRIMARY KEY,"
                + "MaSach varchar(5),"
                + "TinhTrangSach tinyint,"
                + "TinhTrangPhucVu tinyint,"
                + "FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)"
                + ")";
        helper.doSQL(sql);
    }
        public void createTable_SachTG() {
        String sql = "CREATE TABLE SachTG("
                + "MaSach varchar(5) PRIMARY KEY,"
                + "MaTG varchar(5),"
                + "FOREIGN KEY (MaTG) REFERENCES TacGia(MaTG)"
                + ")";
        helper.doSQL(sql);
    }
         public void createTable_DocGia() {
        String sql = "CREATE TABLE DocGia("
                + "SoThe varchar(10) PRIMARY KEY,"
                + "HoTen varchar(30),"
                + "DVCT varchar(50)"
                + ")";
        helper.doSQL(sql);
    } 
             public void createTable_SachMuon() {
        String sql = "CREATE TABLE SachMuon("
                + "SoThe varchar(10) PRIMARY KEY,"
                + "MaCaBiet varchar(10),"
                + "NgayMuon datetime,"
                + "NgayPhaiTra datetime,"
                + "NgayTra datetime,"
                + "FOREIGN KEY (MaCaBiet) REFERENCES ChiTietSach(MaCaBiet)"
                + ")";
        helper.doSQL(sql);
    }
}
