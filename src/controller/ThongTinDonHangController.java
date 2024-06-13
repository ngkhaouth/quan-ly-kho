package controller;

import java.util.ArrayList;

import DAO.ThongTinDonHangDAO;
import model.ChiTietDonHang;

public class ThongTinDonHangController {
	ThongTinDonHangDAO thongTinDAO = new ThongTinDonHangDAO();
	
	public ArrayList<ChiTietDonHang> getListChiTietDonHangById(int maHD) {
		return thongTinDAO.getListChiTietDonHangById(maHD);
	}
	
	public String getTenSanPhamById(int maSP) {
		return thongTinDAO.getTenSanPhamById(maSP);
	}
}
