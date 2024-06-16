package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.ThongTinDonHangDAO;
import model.ChiTietDonHang;
import view.ThongTinDonHang;

public class ThongTinDonHangController {
	ThongTinDonHangDAO thongTinDAO = new ThongTinDonHangDAO();
//	DonHangController tt = new DonHangController();

	
	public ArrayList<ChiTietDonHang> getListChiTietDonHangById(int maHD) {
		return thongTinDAO.getListChiTietDonHangById(maHD);
	}
	
	public String getTenSanPhamById(int maSP) {
		return thongTinDAO.getTenSanPhamById(maSP);
	}
	
	

}
