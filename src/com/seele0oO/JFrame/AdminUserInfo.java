package com.seele0oO.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdminUserInfo extends JFrame {
	private JFrame jf;// 用户信息窗体
	private JTextField textField;// 查询文本框
	private JTable table;// 用户信息表格
	private DefaultTableModel model;// 用户信息表格数据模型
	private JTextField textField_1;// 编号文本框
	private JTextField textField_2;// 用户名文本框
	private JTextField textField_3;// 密码文本框
	private JTextField textField_4;// 性别文本框
	private JTextField textField_5;// 手机号文本框

	public AdminUserInfo() {
		jf = new JFrame("管理员界面");
		jf.setBounds(400, 100, 600, 516);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 类别添加事件---
				jf.dispose();
				new AdminBTypeEdit();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 类别修改事件--------------------//太怪了
				jf.dispose();
				new AdminBTypeEdit();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 书籍添加事件---------------------------待实现

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 书籍修改事件---------------------------待实现

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		menu1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 借阅信息事件---------------------------待实现

			}
		});
		menu1.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 退出系统事件---------------------------待实现

			}
		});
		menuBar.add(mnNewMenu_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "用户信息", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(20, 10, 540, 74);
		jf.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 14));
		lblNewLabel.setBounds(57, 22, 60, 30);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(127, 27, 155, 25);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//查询单击事件---------------------------待实现
				
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton.setBounds(316, 26, 93, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "用户信息列表", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(20, 94, 541, 195);

		/*
		 * 做一个表头栏数据 一位数组
		 */
		String[] title = { "编号", "用户名", "密码", "性别", "电话" };
		/* 具体的各栏行记录 先用空的二位数组占位 */
		String[][] dates = {};
		/* 然后实例化 上面2个控件对象 */
		model = new DefaultTableModel(dates, title);
		table = new JTable(model);
		// 获取数据库数据放置table中--------------------------------待实现
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 496, 154);
		jscrollpane.setViewportView(table);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);
		jf.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "用户编辑", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBounds(20, 302, 540, 137);
		jf.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("编号：");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_1.setBounds(49, 30, 48, 34);
		panel_2.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(103, 37, 66, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("幼圆", Font.BOLD, 15));
		label.setBounds(187, 30, 66, 34);
		panel_2.add(label);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 37, 93, 21);
		panel_2.add(textField_2);

		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 15));
		label_1.setBounds(383, 30, 48, 34);
		panel_2.add(label_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(437, 37, 93, 21);
		panel_2.add(textField_3);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		////修改按钮单击事件---------------------------待实现
				
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 15));
		btnNewButton_1.setBounds(422, 74, 87, 34);
		panel_2.add(btnNewButton_1);

		JLabel label_2 = new JLabel("性别：");
		label_2.setFont(new Font("幼圆", Font.BOLD, 15));
		label_2.setBounds(49, 74, 48, 34);
		panel_2.add(label_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 81, 66, 21);
		panel_2.add(textField_4);

		JLabel label_3 = new JLabel("手机号：");
		label_3.setFont(new Font("幼圆", Font.BOLD, 15));
		label_3.setBounds(187, 74, 66, 34);
		panel_2.add(label_3);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(259, 81, 93, 21);
		panel_2.add(textField_5);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdminUserInfo.class.getResource("/tupian/adBG3.png")));
		lblNewLabel_2.setBounds(0, 0, 584, 457);
		jf.getContentPane().add(lblNewLabel_2);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {		//表格鼠标事件-------------------------待实现
				
			}
		});

		jf.setVisible(true);
		jf.setResizable(true);
	}
	
	public static void main(String[] args) {
		// try {
		// 	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		// 	org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
		new AdminUserInfo();
	}
}
