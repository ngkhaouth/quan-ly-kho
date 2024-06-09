package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.DonHangDAO;
import model.DonHang;
import view.GUI;
import view.ThongTinDonHang;

public class DonHangController {
	private DonHangDAO dhDAO = new DonHangDAO();
	private GUI gui;
	
	
	public DonHangController(DonHangDAO dhDAO, GUI gui) {
		this.dhDAO = dhDAO;
		this.gui = gui;
	}


	public ArrayList<DonHang> getListDonHangConTroller(){
		return dhDAO.getListDonhang();
	}
	
//	new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            // Khi nhấn nút, mở cửa sổ mới từ lớp J
//            ThongTinDonHang jframeThongTinDonHang = new ThongTinDonHang();
//            jframeThongTinDonHang.setVisible(true);
//        }
//    }
}
