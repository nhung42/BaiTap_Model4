/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2.model;

/**
 *
 * @author duong nhung
 * 
 */
public class HoaDon {
    private String maHD, maNV, loaiHD, ngayLap, ngayGiao;

    public HoaDon(String maHD, String maNV, String loaiHD, String ngayLap, String ngayGiao) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.loaiHD = loaiHD;
        this.ngayLap = ngayLap;
        this.ngayGiao = ngayGiao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        this.ngayGiao = ngayGiao;
    }
    
    
}
