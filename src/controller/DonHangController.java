package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.DonHangDAO;
import model.DonHang;
import view.GUI;
import view.ThongTinDonHang;

public class DonHangController implements ActionListener{
	private DonHangDAO dhDAO = new DonHangDAO();
	private GUI gui;
	private ThongTinDonHang ttdhview;
	
	
	
	public DonHangController() {
	}

	public DonHangController(GUI gui) {
		this.gui = gui;
	}

	public DonHangController(DonHangDAO dhDAO, GUI gui) {
		this.dhDAO = dhDAO;
		this.gui = gui;
	}


	public ArrayList<DonHang> getListDonHangConTroller(){
		return dhDAO.getListDonhang();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = gui.ordersTable.getSelectedRow();
        if (selectedRow != -1) {
        	String orderIdStr = (String) gui.ordersTable.getValueAt(selectedRow, 0);
        	int orderId = Integer.parseInt(orderIdStr);
            ttdhview = new ThongTinDonHang(orderId);
            ttdhview.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(gui, "Vui lòng chọn một đơn hàng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
	}
	
}
