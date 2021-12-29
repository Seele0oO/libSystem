package com.seele0oO.JFrame;


//import dao.BookDao;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminBookAdd extends JFrame {
	private JFrame jf;//图书添加窗体
	private JTextField textField;//书名文本框
	private JTextField textField_1;//作者文本框
	private JTextField textField_2;//出版社文本框
	private JTextField textField_3;//库存文本框
	private JTextField textField_4;//价格文本框
	private JTextField textField_6;//描述数据文本框
	private JComboBox comboBox;//类别组合框
//	BookDao sd= (BookDao) new BookDaoimpl();
	
	public AdminBookAdd(){
		jf=new JFrame("管理员界面");
		jf.setBounds(400, 100, 600, 378);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "书籍添加", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(23, 21, 540, 275);
		jf.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("书名：");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 14));
		lblNewLabel.setBounds(58, 31, 45, 27);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 31, 129, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("作者：");
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setBounds(294, 31, 45, 27);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(338, 31, 128, 27);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("出版社：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setBounds(43, 79, 60, 27);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 79, 129, 27);
		panel.add(textField_2);
		
		JLabel label_2 = new JLabel("库存：");
		label_2.setFont(new Font("幼圆", Font.BOLD, 14));
		label_2.setBounds(58, 125, 45, 27);
		panel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 125, 129, 27);
		panel.add(textField_3);
		
		JLabel label_3 = new JLabel("价格：");
		label_3.setFont(new Font("幼圆", Font.BOLD, 14));
		label_3.setBounds(294, 79, 45, 27);
		panel.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(337, 79, 129, 27);
		panel.add(textField_4);
		
		JLabel label_4 = new JLabel("类别：");
		label_4.setFont(new Font("幼圆", Font.BOLD, 14));
		label_4.setBounds(294, 125, 45, 27);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("描述：");
		label_5.setFont(new Font("幼圆", Font.BOLD, 14));
		label_5.setBounds(58, 170, 45, 27);
		panel.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(101, 173, 365, 27);
		panel.add(textField_6);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//添加按钮单击事件-------------------------待实现
			
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton.setBounds(124, 227, 77, 27);
		panel.add(btnNewButton);
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//重置按钮单击事件-------------------------待实现
				
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 14));
		button.setBounds(329, 229, 77, 27);
		panel.add(button);
		
		comboBox = new JComboBox();
		comboBox.setBounds(338, 126, 128, 26);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminBookAdd.class.getResource("/tupian/adBG2.png")));
		lblNewLabel_1.setBounds(0, -4, 584, 323);
		jf.getContentPane().add(lblNewLabel_1);
		//类别组合框初始化----------------------------------待实现
		
		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//类别添加事件-----------------待实现
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//类别修改事件-----------------待实现
		
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//书籍修改事件-----------------待实现
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//用户信息事件-----------------待实现
				
			}
		});
		menu1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//借阅信息事件-----------------待实现
				
			}
		});
		menu1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//退出系统事件-----------------待实现
				
			}
		});
		menuBar.add(mnNewMenu_1);
	
		jf.setVisible(true);
		jf.setResizable(true);
	}

	public static void main(String[] args) {
//		try {
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		new AdminBookAdd();
	}
}
