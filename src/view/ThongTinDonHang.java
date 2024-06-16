package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.DonHangController;
import controller.ThongTinDonHangController;
import controller.TrangThaiDonHangController;
import model.ChiTietDonHang;
import model.TrangThaiDonHang;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ThongTinDonHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int orderId;
	private ThongTinDonHangController thongTinCon = new ThongTinDonHangController();
	private DefaultTableModel modelSanPham;
	private JButton btnXacNhan;
	private TrangThaiDonHangController trangThaiCon = new TrangThaiDonHangController();
	private TrangThaiDonHangController ttdhCon;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ThongTinDonHang frame = new ThongTinDonHang();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ThongTinDonHang(int orderId, GUI gui) {
		this.orderId = orderId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN ĐƠN HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		modelSanPham = new DefaultTableModel();
//		modelSanPham.addColumn("Mã HD");
		modelSanPham.addColumn("Mã SP");
		modelSanPham.addColumn("Tên SP");
		modelSanPham.addColumn("Số Lượng");
		modelSanPham.addColumn("Đơn Giá");
		table = new JTable(modelSanPham);
		
		loadDataToTableThongTinDH();

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(208, 215, 208)); // Màu sắc được chỉ định bằng mã màu RGB

        // Duyệt qua từng cột trong bảng và thiết lập renderer cho tiêu đề cột
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnXacNhan = new JButton("Xác nhận tạo đơn");
		btnXacNhan.setBackground(new Color(255, 185, 55));
		panel_2.add(btnXacNhan);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trangThaiCon.addDonHangInListTrangThaiDonHang(orderId);
				gui.loadDataToTableTrangThaiDH();
				dispose();
			}

		});
	}
	public void loadDataToTableThongTinDH() {
		ArrayList<ChiTietDonHang> chiTietDonHangList = thongTinCon.getListChiTietDonHangById(orderId);
		
		if(chiTietDonHangList != null) {
//			ThongTinDonHang ttdh = new ThongTinDonHang(orderId);
//			modelSanPham.setRowCount(0);
			
			for(ChiTietDonHang x : chiTietDonHangList) {
				String tenSP = thongTinCon.getTenSanPhamById(x.getMaSP());
				Vector<String> vec = new Vector<String>();
				vec.add(x.getMaSP() + "");
				vec.add(tenSP);
				vec.add(x.getSoLuong() + "");
				vec.add(x.getDonGia() + "");
				
				modelSanPham.addRow(vec);
			}
		}else {
            JOptionPane.showMessageDialog(this, "Không thể tải dữ liệu chi tiết đơn hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
	
	}
	
	
}
