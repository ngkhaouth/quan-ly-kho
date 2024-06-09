package controller;

import java.util.ArrayList;

import DAO.TrangThaiDonHangDAO;
import model.TrangThaiDonHang;

public class TrangThaiDonHangController {
	private	TrangThaiDonHangDAO ttdhDAO = new TrangThaiDonHangDAO();
	
	public ArrayList<TrangThaiDonHang> getListTrangThaiDonHang() {
		return ttdhDAO.getListTrangThaiDonHang();
	}
}
