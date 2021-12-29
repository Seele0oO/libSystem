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


public class UserMenuFrm extends JFrame {
	private JFrame jf; // 用户窗体界面
	private JLabel lblNewLabel_1; // 当前登录用户名
	private JLabel lblNewLabel_2; // 欢迎您
	private JTable table; // 借阅信息表格组件
	private DefaultTableModel model; // 借阅信息表格组件所需要的数据模型
	private JTextField textField; // 还书编号
	private JButton btnBackBook; // 还书按钮
	private JButton button; // 退出系统按钮
	private JPanel panel_2; // 初始化展示图书所需要的面板
	private JComboBox comboBox; // 搜索下拉选择框
	private JTextField textField_1; // 搜索文本框
	private JButton button_1; // 查询按钮
	private JTable bookTable; // 展示图书信息表格组件
	private DefaultTableModel bookModel; // 展示图书信息表格组件所需要的数据模型
	private JTextField textField_2; // 借书编号文本框
	private JTextField textField_3; // 借书书名文本框
	private JLabel lblNewLabel_3; // 窗体背景图片

	public UserMenuFrm() {
		jf = new JFrame();
		jf.setTitle("用户页面");
		jf.setBounds(250, 100, 700, 902);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		// 借阅信息面板
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "借阅信息", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(23, 48, 651, 239);

		// 做一个表头栏数据 一维数组
		String[] title = { "编号", "书名", "状态", "借书时间", "还书时间" };
		// 具体的各栏行记录 先用空的二位数组占位
		String[][] dates = {};
		// 然后实例化 上面2个控件对象
		model = new DefaultTableModel(dates, title);
		table = new JTable();
		table.setModel(model);

		// 获取当前登录用户借阅数据记录--------------------------------待实现

		// 表格添加到滚动面板中，滚动面板添加到panel_1中，panel_1添加到jf中
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 607, 188);
		jscrollpane.setViewportView(table);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(315, 10, 197, 28);
//		User currentUser = LoginAdjust.currentUser;
//		lblNewLabel_1.setText(currentUser.getUsername());

		jf.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("欢迎您,");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setBounds(254, 11, 258, 28);
		jf.getContentPane().add(lblNewLabel_2);
		// 还书面板
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "还书", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(23, 294, 651, 70);
		jf.getContentPane().add(panel);
		panel.setLayout(null);
		// 编号
		JLabel lblNewLabel = new JLabel("编号：");
		lblNewLabel.setBounds(90, 25, 51, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));
		// 编号文本框
		textField = new JTextField();
		textField.setBounds(145, 28, 116, 24);
		panel.add(textField);
		textField.setColumns(10);
		// 还书按钮
		btnBackBook = new JButton("还书");
		btnBackBook.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBackBook.setBounds(299, 25, 85, 31);
		panel.add(btnBackBook);
		// 退出系统按钮
		button = new JButton("退出系统");
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBounds(407, 25, 103, 31);
		panel.add(button);
		// 图书信息面板
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "图书信息", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBounds(23, 374, 651, 346);
		jf.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		// 搜索关键字文本框
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 23, 135, 27);
		panel_2.add(textField_1);
		// 查询按钮
		button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 查询按钮单击事件----------------待实现

			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 16));
		button_1.setBounds(408, 20, 93, 33);
		panel_2.add(button_1);
		// 查询图书下列组合框
		comboBox = new JComboBox();
		comboBox.setFont(new Font("幼圆", Font.BOLD, 15));
		comboBox.setBounds(123, 26, 109, 24);
		comboBox.addItem("书籍名称");
		comboBox.addItem("书籍作者");
		panel_2.add(comboBox);
		// 图书信息对应的表头
		String[] BookTitle = { "编号", "书名", "类型", "作者", "描述" };
		// 具体的各栏行记录 先用空的二位数组占位
		String[][] BookDates = {};
		// 然后实例化 上面2个控件对象
		bookModel = new DefaultTableModel(BookDates, BookTitle);
		bookTable = new JTable(bookModel);
		// 获取所有图书信息--------------------------------待实现
		panel_2.setLayout(null);
		JScrollPane jscrollpane1 = new JScrollPane();
		jscrollpane1.setBounds(22, 74, 607, 250);
		jscrollpane1.setViewportView(bookTable);
		panel_2.add(jscrollpane1);
		jf.getContentPane().add(panel_1);
		// 借书面板
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "借书", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(23, 730, 645, 87);
		jf.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		// 编号
		JLabel label = new JLabel("编号：");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(68, 31, 48, 33);
		panel_3.add(label);
		// 编号文本框
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(126, 34, 135, 27);
		panel_3.add(textField_2);
		// 书名
		JLabel label_1 = new JLabel("书名：");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(281, 31, 48, 33);
		panel_3.add(label_1);
		// 书名文本框
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(339, 34, 135, 27);
		panel_3.add(textField_3);
		// 借书按钮
		JButton button_2 = new JButton("借书");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 借书命令按钮单击事件------------------------待实现

			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 16));
		button_2.setBounds(495, 31, 80, 33);
		panel_3.add(button_2);
		// 窗体背景图片
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UserMenuFrm.class.getResource("/tupian/uBG.png")));
		lblNewLabel_3.setBounds(0, 0, 684, 864);
		jf.getContentPane().add(lblNewLabel_3);
		// 借书表格添加鼠标事件监听器
		bookTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 鼠标按下事件--------------待实现

			}
		});
		// 退出按钮添加动作监听器
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 退出按钮单击事件-------------待实现

			}
		});
		btnBackBook.setVisible(false); // 隐藏还书按钮
		// 还书按钮添加动作监听器
		btnBackBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 还书按钮单击事件-------------待实现

			}
		});

		// 显示窗体，大小不可改变
		jf.setVisible(true);
		jf.setResizable(true);
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new UserMenuFrm();
	}
}