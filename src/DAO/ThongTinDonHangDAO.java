package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ThongTinDonHangDAO {
	private MyConnect myConnect = new MyConnect();
	public ArrayList<ChiTietDonHang> getListChiTietDonHangById(int maHD) {
    	ArrayList<ChiTietDonHang> arr = new ArrayList<>();
    	String sql = "SELECT * FROM chitietdonhang WHERE MaDH = ?";
    	
    	if(myConnect.openConnectDB()) {
    		try {
				PreparedStatement statement = myConnect.conn.prepareStatement(sql);
				statement.setInt(1, maHD);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					int maDH = resultSet.getInt("MaDH");
					int maCTDH = resultSet.getInt("MaCTDH");
					int maSP = resultSet.getInt("MaSP");
					int maSL = resultSet.getInt("SoLuong");
					float donGia = resultSet.getInt("DonGia");
					
					ChiTietDonHang ctdh = new ChiTietDonHang();
					ctdh.setMaDH(maDH);
					ctdh.setMaCTDH(maCTDH);
					ctdh.setMaSP(maSP);
					ctdh.setSoLuong(maSL);
					ctdh.setDonGia(donGia);
					
					arr.add(ctdh);
				}
	            statement.close();
	            resultSet.close();
	            myConnect.closeConnectDB();
	            
	            return arr;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	return null;
	}
	
	
	public String getTenSanPhamById(int maSP) {
		String tenSP = null;
		String sql = "SELECT TenSP FROM sanpham WHERE MaSP = ?";
		
    	if(myConnect.openConnectDB()) {
    		try {
				PreparedStatement statement = myConnect.conn.prepareStatement(sql);
				statement.setInt(1, maSP);
				ResultSet resultSet = statement.executeQuery();
				
				if(resultSet.next()) {
					tenSP = resultSet.getString("TenSP");
				}
				
	            statement.close();
	            resultSet.close();
	            myConnect.closeConnectDB();
	            
	            return tenSP;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	return null;
	}
}
