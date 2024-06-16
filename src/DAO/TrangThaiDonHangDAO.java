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

		if (myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();

//				Trỏ đến từng bản ghi và duyệt qua kết quả và tạo đối tượng TrangThaiDonHang
				while (resultSet.next()) {
					int maDH = resultSet.getInt("MaTrangThaiDH");
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

	public void addOneTrangThaiDonHangDAO(TrangThaiDonHang tt) {
		String sql = "INSERT INTO TrangThaiDonHang (MaDH, TenDH, KhachHang, NgayDat, NgayGiao, TinhTrang) VALUES (?, ?, ?, ?, ?, ?)";

		if (myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(sql);

					// Thiết lập các tham số cho câu lệnh SQL
					statement.setInt(1, tt.getMaDH());
					statement.setString(2, tt.getTenDH());
					statement.setString(3, tt.getKhachHang());
					statement.setDate(4, (Date) tt.getNgayDat());
					statement.setDate(5, (Date) tt.getNgayGiao());
					statement.setString(6, tt.getTinhTrang());

					// Thực thi câu lệnh SQL
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("A new status has been inserted successfully!");
					}

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkExistID(int id) {
		String query = "SELECT * FROM TrangThaiDonHang where MaDH = " + id;

		if (myConnect.openConnectDB()) {
			try {
				PreparedStatement statement = myConnect.conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();

//				Trỏ đến từng bản ghi và duyệt qua kết quả và tạo đối tượng TrangThaiDonHang
				while (resultSet.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
