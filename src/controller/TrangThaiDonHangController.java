package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.TrangThaiDonHangDAO;
import model.DonHang;
import model.TrangThaiDonHang;

public class TrangThaiDonHangController {
	private	TrangThaiDonHangDAO ttdhDAO = new TrangThaiDonHangDAO();
	DonHangController dhCon = new DonHangController();
	
	public ArrayList<TrangThaiDonHang> getListTrangThaiDonHang() {
		return ttdhDAO.getListTrangThaiDonHang();
	}
	
	public void addDonHangInListTrangThaiDonHang(int id) {
		if(ttdhDAO.checkExistID(id)) {
			System.out.println("Da ton tai");
			return;
		}
		DonHang dh = new DonHang();
		dh = dhCon.getDonhangByID(id);
		TrangThaiDonHang ttdh = new TrangThaiDonHang();
		ttdh.setMaDH(dh.getMaDH());
		ttdh.setTenDH(dh.getTenDH());
		ttdh.setKhachHang(dh.getKhachHang());
		ttdh.setNgayDat(dh.getNgayDat());
		ttdh.setNgayGiao(dh.getNgayGiao());
		ttdh.setTinhTrang("Đang xử lý");
		
		ttdhDAO.addOneTrangThaiDonHangDAO(ttdh);
	}
	
}
