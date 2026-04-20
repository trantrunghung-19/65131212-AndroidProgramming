package com.example.thigk2trantrunghung;

public class DiaDiem {
    private String ten;
    private String diaChi;
    private String anh;

    public DiaDiem(String ten, String diaChi, String anh) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getAnh() {
        return anh;
    }
}