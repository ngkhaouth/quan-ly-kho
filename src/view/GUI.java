package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.DonHangController;
import controller.TrangThaiDonHangController;
import model.DonHang;
import model.TrangThaiDonHang;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable ordersTable;
	private JTable table_1;
	DonHangController dhCon = new DonHangController();
	TrangThaiDonHangController ttdhCon = new TrangThaiDonHangController();
	private DefaultTableModel modelHoaDon;
	public DefaultTableModel modelTinhTrang;
	public JButton btnTaoDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		RoundedPanel jPanelMenu = new RoundedPanel(50, Color.WHITE);
		jPanelMenu.setLayout(new BorderLayout(0, 0));
		contentPane.add(jPanelMenu, BorderLayout.WEST);
		

		
		JLabel labelHouse = new JLabel("");
		labelHouse.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/House.png")).getImage();
		labelHouse.setIcon(new ImageIcon(img));
		jPanelMenu.add(labelHouse);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
//		RoundedPanel panel = new RoundedPanel(50, Color.WHITE);
//		panel.setBackground(Color.WHITE);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());

		
		JLabel labelDH = new JLabel("Đơn Hàng");
		labelDH.setHorizontalAlignment(SwingConstants.CENTER);
		labelDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgDH = new ImageIcon(this.getClass().getResource("/icon_DonHang.png")).getImage();
		Image sacledImgDH = imgDH.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelDH.setIcon(new ImageIcon(sacledImgDH));
		labelDH.setBounds(29, 88, 140, 50);
		panel.add(labelDH);
		
		labelDH.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelTK = new JLabel("Tồn Kho");
		labelTK.setHorizontalAlignment(SwingConstants.CENTER);
		labelTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTK = new ImageIcon(this.getClass().getResource("/icon_TonKho.png")).getImage();
		Image sacledImgTK = imgTK.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTK.setIcon(new ImageIcon(sacledImgTK));
		labelTK.setBounds(29, 149, 140, 50);
		panel.add(labelTK);
		
		labelTK.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelNX = new JLabel("Nhập/Xuất");
		labelNX.setHorizontalAlignment(SwingConstants.CENTER);
		labelNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgNX = new ImageIcon(this.getClass().getResource("/icon_NhapXuat.png")).getImage();
		Image sacledImgNX = imgNX.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelNX.setIcon(new ImageIcon(sacledImgNX));
		labelNX.setBounds(29, 197, 140, 50);
		panel.add(labelNX);
		
		labelNX.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelVT = new JLabel("Vị Trí Kho");
		labelVT.setHorizontalAlignment(SwingConstants.CENTER);
		labelVT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgVT = new ImageIcon(this.getClass().getResource("/icon_ViTri.png")).getImage();
		Image sacledImgVT = imgVT.getScaledInstance(40, 36, Image.SCALE_SMOOTH);
		labelVT.setIcon(new ImageIcon(sacledImgVT));
		labelVT.setBounds(29, 258, 140, 50);
		panel.add(labelVT);
		
		labelVT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelQT = new JLabel("Quản Trị");
		labelQT.setHorizontalAlignment(SwingConstants.CENTER);
		labelQT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgQT = new ImageIcon(this.getClass().getResource("/icon_QuanTri.png")).getImage();
		Image sacledImgQT = imgQT.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelQT.setIcon(new ImageIcon(sacledImgQT));
		labelQT.setBounds(29, 319, 140, 50);
		panel.add(labelQT);
		
		labelQT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelTKe = new JLabel("Thống kê");
		labelTKe.setHorizontalAlignment(SwingConstants.CENTER);
		labelTKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Image imgTKe = new ImageIcon(this.getClass().getResource("/icon_ThongKe.png")).getImage();
		Image sacledImgTKe = imgTKe.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		labelTKe.setIcon(new ImageIcon(sacledImgTKe));
		labelTKe.setBounds(29, 376, 140, 50);
		panel.add(labelTKe);
		
		labelTKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(Box.createVerticalStrut(10));
		panel.add(Box.createVerticalGlue());
		
		jPanelMenu.add(labelHouse, BorderLayout.NORTH);
		jPanelMenu.add(panel, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thông báo đơn hàng", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		btnTaoDon = new JButton("Tạo đơn");
		btnTaoDon.setBackground(new Color(255, 185, 55));
		panel_3.add(btnTaoDon);
		DonHangController donhangCon = new DonHangController(this);
		btnTaoDon.addActionListener(donhangCon);
		
		modelHoaDon = new DefaultTableModel();
		modelHoaDon.addColumn("Mã HD");
        modelHoaDon.addColumn("Tên HD");
        modelHoaDon.addColumn("Khách Hàng");
        modelHoaDon.addColumn("Ngày Đặt");
        modelHoaDon.addColumn("Ngày Giao");
		

		ordersTable = new JTable(modelHoaDon);

		loadDataToTableDonHang();
		
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(208, 215, 208)); // Màu sắc được chỉ định bằng mã màu RGB
        // Duyệt qua từng cột trong bảng và thiết lập renderer cho tiêu đề cột
        for (int i = 0; i < ordersTable.getColumnCount(); i++) {
        	ordersTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
		JScrollPane scrollPane = new JScrollPane(ordersTable);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Trạng thái đơn hàng", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		

		modelTinhTrang = new DefaultTableModel();
		modelTinhTrang.addColumn("Mã đơn hàng");
		modelTinhTrang.addColumn("Tình trạng đơn hàng");
		
		table_1 = new JTable(modelTinhTrang);
		loadDataToTableTrangThaiDH();
		
        for (int i = 0; i < table_1.getColumnCount(); i++) {
        	table_1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
	}
	
	public void loadDataToTableDonHang() {
		ArrayList<DonHang> arr = new ArrayList<>();
		arr = dhCon.getListDonHangConTroller();
		if(arr != null) {
			for(DonHang x : arr) {
				Vector<String> vec = new Vector<String>();
				vec.add(x.getMaDH()+"");
				vec.add(x.getTenDH());
				vec.add(x.getKhachHang());
				vec.add(x.getNgayDat() + "");
				vec.add(x.getNgayGiao()+"");
				modelHoaDon.addRow(vec);
			}
		}
	}

	public void loadDataToTableTrangThaiDH() {
		modelTinhTrang.setRowCount(0);
		ArrayList<TrangThaiDonHang> list = new ArrayList<TrangThaiDonHang>();
		list = ttdhCon.getListTrangThaiDonHang();
		if(list != null) {
			for(TrangThaiDonHang x : list) {
				Vector<String> vec = new Vector<String>();
				vec.add(x.getMaDH() + "");
				vec.add(x.getTinhTrang());
				modelTinhTrang.addRow(vec);
				
			}
		}
	}
	
}

	