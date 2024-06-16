package model;

import java.util.Date;

public class TrangThaiDonHang {
    private int maDH;
    private String tenDH;
    private String khachHang;
    private Date ngayDat;
    private Date ngayGiao;
    private String tinhTrang;

    // Constructor
    public TrangThaiDonHang() {
    }

    public TrangThaiDonHang(int maDH, String tenDH, String khachHang, Date ngayDat, Date ngayGiao, String tinhTrang) {
        this.maDH = maDH;
        this.tenDH = tenDH;
        this.khachHang = khachHang;
        this.ngayDat = ngayDat;
        this.ngayGiao = ngayGiao;
        this.tinhTrang = tinhTrang;
    }

    // Getters and Setters
    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public String getTenDH() {
        return tenDH;
    }

    public void setTenDH(String tenDH) {
        this.tenDH = tenDH;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date date) {
        this.ngayDat =  date;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "TrangThaiDonHang{" +
                "maDH=" + maDH +
                ", tenDH='" + tenDH + '\'' +
                ", khachHang='" + khachHang + '\'' +
                ", ngayDat=" + ngayDat +
                ", ngayGiao=" + ngayGiao +
                ", tinhTrang='" + tinhTrang + '\'' +
                '}';
    }
}
