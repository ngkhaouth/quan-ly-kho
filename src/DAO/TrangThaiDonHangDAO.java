package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TrangThaiDonHang;

public class TrangThaiDonHangDAO {
	private MyConnect myConnect = new MyConnect();
	
	public ArrayList<TrangThaiDonHang> getListTrangThaiDonHang() {
		ArrayList<TrangThaiDonHang> list = new ArrayList<TrangThaiDonHang>();
		String query = "SELECT * FROM TrangThaiDonHang";
		
		
		if(myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();
				
//				Trỏ đến từng bản ghi và duyệt qua kết quả và tạo đối tượng TrangThaiDonHang
				while( resultSet.next()) {
	                int maDH = resultSet.getInt("MaDH");
	                String tenDH = resultSet.getString("TenDH");
	                String khachHang = resultSet.getString("KhachHang");
	                Date ngayDat = resultSet.getDate("NgayDat");
	                Date ngayGiao = resultSet.getDate("NgayGiao");
	                String tinhTrang = resultSet.getString("TinhTrang");
	                TrangThaiDonHang tt = new TrangThaiDonHang();
	                tt.setMaDH(maDH);
	                tt.setTenDH(tenDH);
	                tt.setKhachHang(khachHang);
	                tt.setNgayDat(ngayDat);
	                tt.setNgayGiao(ngayGiao);
	                tt.setTinhTrang(tinhTrang);
	                
	                list.add(tt);
				}
			    return list;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
			return null;
	}
}
