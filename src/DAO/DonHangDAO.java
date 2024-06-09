package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;

public class DonHangDAO {
	private MyConnect conDB = new MyConnect();

    // Hàm khởi tạo để kết nối đến cơ sở dữ liệu
    public DonHangDAO() {
    }
    
    public ArrayList<DonHang> getListDonhang(){
    	ArrayList<DonHang> arr = new ArrayList<>();
    	String sql = "SELECT * FROM DonHang";
    	
    	if(conDB.openConnectDB()) {
    		try {
        		PreparedStatement statement = conDB.conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int maDH = resultSet.getInt("MaDH");
                    String tenDH = resultSet.getString("TenDH");
                    String khachHang = resultSet.getString("KhachHang");
                    Date ngayDat = resultSet.getDate("NgayDat");
                    Date ngayGiao = resultSet.getDate("NgayGiao");
                    DonHang dh = new DonHang();
                    dh.setMaDH(maDH);
                    dh.setTenDH(tenDH);
                    dh.setKhachHang(khachHang);
                    dh.setNgayDat(ngayDat);
                    dh.setNgayGiao(ngayGiao);
                    arr.add(dh);
                }
                return arr;
        	} catch (SQLException e) {
                e.printStackTrace();
            }
    	}
    	return null;
    }
}
