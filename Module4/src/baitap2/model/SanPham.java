/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2.model;

/**
 *
 * @author duong nhung
 */
public class SanPham {
    private String maSP, tenSP, donViTinh, gia;

    public SanPham(String maSP, String tenSP, String donViTinh, String gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    
    
}
