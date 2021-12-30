package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Dao.BookTypeDaoImpl;
import com.seele0oO.jdbc.Unit.DBInJ;
import com.seele0oO.jdbc.model.bookType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class AdminBookEdit extends JFrame {
	private JFrame jf;// 书籍修改窗体
	private JTextField textField;// 查询文本框
	private JTable table;// 书籍信息表格
	private DefaultTableModel model;// 书籍信息表格数据模型
	private JTextField textField_1;// 编号文本框
	private JTextField textField_2;// 书名文本框
	private JTextField textField_3;// 作者文本框
	private JTextField textField_4;// 价格文本框
	private JTextField textField_5;// 出版社文本框
	private JTextField textField_6;// 库存文本框
	private JTextField textField_7;// 图书描述信息文本框
	private JComboBox comboBox;// 查询组合框
	private JComboBox comboBox_2;// 上下架状态组合框
	private JComboBox comboBox_1;// 图书类别组合框

	private Integer selectRow;
	public AdminBookEdit() {
		jf = new JFrame("管理员界面");
		jf.setBounds(400, 50, 600, 672);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 类别添加事件----------------------
				jf.dispose();
				new AdminMenuFrm();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 类别修改事件---------------------
				jf.dispose();
				new AdminBTypeEdit();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 书籍添加事件---------------------
				jf.dispose();
				new AdminBookAdd();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 用户信息事件-------------------
				jf.dispose();
				new AdminUserInfo();
			}
		});
		menu1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 借阅信息事件---------------------
				jf.dispose();
				new AdminBorrowInfo();
			}
		});
		menu1.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 退出系统事件----------------------
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_1);

		jf.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "书籍查询", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(20, 10, 541, 78);
		jf.getContentPane().add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("幼圆", Font.BOLD, 15));
		comboBox.setBounds(55, 28, 109, 24);
		comboBox.addItem("书籍名称");
		comboBox.addItem("书籍作者");
		panel.add(comboBox);

		textField = new JTextField();
		textField.setBounds(185, 28, 146, 24);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 查询按钮单击事件-------------------待实现
				DBInJ.fastPreparedExecuteQuery("SELECT book.*, book_type.type_name FROM book, book_type WHERE "
						+ (comboBox.getSelectedIndex() == 0 ? "book_name" : "author")
						+ " LIKE ? AND book.type_id = book_type.id", (ResultSet resultSet) -> {
					initializeBookTableData(resultSet);
					return null;
				}, "%" + textField.getText() + "%");
			}

			private void initializeBookTableData(ResultSet resultSet) throws SQLException {
				TableModel model = table.getModel();
				if (model instanceof DefaultTableModel defaultTableModel)
				{
					defaultTableModel.setRowCount(0);
					while (resultSet.next())
					{
						Vector<Object> rowData = new Vector<>();
						rowData.add(resultSet.getInt("id"));
						rowData.add(resultSet.getString("book_name"));
						rowData.add(resultSet.getString("type_name"));
						rowData.add(resultSet.getString("author"));
						rowData.add(resultSet.getDouble("price"));
						rowData.add(resultSet.getInt("number"));
						rowData.add(resultSet.getInt("status"));
//						rowData.add(resultSet.getString("remark"));
						defaultTableModel.addRow(rowData);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton.setBounds(352, 28, 81, 25);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "书籍信息", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(20, 105, 541, 195);

		/*
		 * 做一个表头栏数据 一位数组
		 */
		String[] title = { "编号", "书名", "类别", "作者", "价格", "库存", "状态" };
		/* 具体的各栏行记录 先用空的二位数组占位 */
		String[][] dates = {};
		/* 然后实例化 上面2个控件对象 */
		model = new DefaultTableModel(dates, title);
		table = new JTable(model);
		// 获取数据库数据放置table中---------------------------待实现
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 496, 154);
		jscrollpane.setViewportView(table);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);
		jf.getContentPane().add(panel_1);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 表格鼠标事件---------------------待实现
//				selectRow = (Integer)table.getSelectedRow();
				selectRow = Integer.valueOf(table.getSelectedRow());
				System.out.println(selectRow);
				textField_1.setText(String.valueOf(table.getModel().getValueAt(selectRow,0)));// 编号文本框
				textField_2.setText(String.valueOf(table.getModel().getValueAt(selectRow,1)));// 书名文本框
				textField_3.setText(String.valueOf(table.getModel().getValueAt(selectRow,2)));// 作者文本框
				textField_4.setText(String.valueOf(table.getModel().getValueAt(selectRow,3)));// 价格文本框
				textField_5.setText(String.valueOf(table.getModel().getValueAt(selectRow,4)));// 出版社文本框
				textField_6.setText(String.valueOf(table.getModel().getValueAt(selectRow,5)));// 库存文本框
				textField_7.setText(String.valueOf(table.getModel().getValueAt(selectRow,6)));// 图书描述信息文本框


				BookTypeDaoImpl bt = new BookTypeDaoImpl();
				ArrayList<bookType> allBookTypes = bt.findAllBookTypes();
				for (int i = 0; i < allBookTypes.size(); i++) {
					String typeName = allBookTypes.get(i).getTypeName();
					comboBox_1.addItem(typeName);
				}
				JComboBox comboBox;// 查询组合框
				JComboBox comboBox_2;// 上下架状态组合框
				JComboBox comboBox_1;// 图书类别组合框
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 310, 541, 292);
		jf.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("编号：");
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setBounds(58, 10, 45, 27);
		panel_2.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 10, 129, 27);
		panel_2.add(textField_1);

		JLabel label_1 = new JLabel("书名：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setBounds(294, 10, 45, 27);
		panel_2.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(338, 10, 128, 27);
		panel_2.add(textField_2);

		JLabel label_2 = new JLabel("作者：");
		label_2.setFont(new Font("幼圆", Font.BOLD, 14));
		label_2.setBounds(58, 58, 45, 27);
		panel_2.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 58, 129, 27);
		panel_2.add(textField_3);

		JLabel label_3 = new JLabel("价格：");
		label_3.setFont(new Font("幼圆", Font.BOLD, 14));
		label_3.setBounds(58, 104, 45, 27);
		panel_2.add(label_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 104, 129, 27);
		panel_2.add(textField_4);

		JLabel label_4 = new JLabel("出版：");
		label_4.setFont(new Font("幼圆", Font.BOLD, 14));
		label_4.setBounds(294, 58, 45, 27);
		panel_2.add(label_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(337, 58, 129, 27);
		panel_2.add(textField_5);

		JLabel label_5 = new JLabel("类别：");
		label_5.setFont(new Font("幼圆", Font.BOLD, 14));
		label_5.setBounds(58, 189, 45, 27);
		panel_2.add(label_5);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(102, 190, 128, 26);
		// 获取类别----------------------------------------------待实现
		panel_2.add(comboBox_1);

		JLabel label_6 = new JLabel("库存：");
		label_6.setFont(new Font("幼圆", Font.BOLD, 14));
		label_6.setBounds(294, 104, 45, 27);
		panel_2.add(label_6);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(337, 104, 129, 27);
		panel_2.add(textField_6);

		JLabel label_7 = new JLabel("描述：");
		label_7.setFont(new Font("幼圆", Font.BOLD, 14));
		label_7.setBounds(58, 152, 45, 27);
		panel_2.add(label_7);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(101, 152, 365, 27);
		panel_2.add(textField_7);

		JLabel label_8 = new JLabel("状态：");
		label_8.setFont(new Font("幼圆", Font.BOLD, 14));
		label_8.setBounds(294, 190, 45, 27);
		panel_2.add(label_8);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(338, 191, 128, 26);
		comboBox_2.addItem("上架");
		comboBox_2.addItem("下架");
		panel_2.add(comboBox_2);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 修改按钮单击事件-------------------待实现

			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton_1.setBounds(304, 235, 93, 35);
		panel_2.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminBookEdit.class.getResource("/tupian/adBG3.png")));
		lblNewLabel.setBounds(0, 0, 584, 613);
		jf.getContentPane().add(lblNewLabel);

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
		new AdminBookEdit();
	}
}
