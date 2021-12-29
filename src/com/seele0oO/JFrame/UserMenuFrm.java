package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Dao.BookDao;
import com.seele0oO.jdbc.Dao.BorrowDetailDaoImpl;
import com.seele0oO.jdbc.Dao.UserDaoImpl;
import com.seele0oO.jdbc.Unit.DBInJ;
import com.seele0oO.jdbc.Unit.JDBCUtils;
import com.seele0oO.jdbc.model.Book;
import com.seele0oO.jdbc.model.User;
import com.seele0oO.jdbc.model.borrowDetail;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import static com.seele0oO.JFrame.LoginFrm.currentUser;


public class UserMenuFrm extends JFrame {
	private JFrame jf; // 用户窗体界面
	private JLabel lblNewLabel_1; // 当前登录用户名
	private JLabel lblNewLabel_2; // 欢迎您
	private JTable borrowTable; // 借阅信息表格组件
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
	//	private JTextField textField_2; // 借书编号文本框
//	private JTextField textField_3; // 借书书名文本框
	private JLabel lblNewLabel_3; // 窗体背景图片

	private Integer selectRow;//选中行
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

		BorrowDetailDaoImpl sd = new BorrowDetailDaoImpl();
		ArrayList<borrowDetail> bwlist;
//没有userid！！！！！
		bwlist = sd.getBorrowDetailList(currentUser.getId());

		String[][] dataArr = new String[bwlist.size()][];



		// 获取当前登录用户借阅数据记录--------------------------------待实现
//		UserDaoImpl sd = new UserDaoImpl();
//		User getuser = sd.findByname(username);


//		System.out.println(bwlist);
		System.out.println("---------------------------");
		for (int i = 0; i < bwlist.size(); i++) {
//			System.out.println(bwlist.get(i));
			dataArr[i] = new String[5];
			dataArr[i][0] = String.valueOf(bwlist.get(i).getId());
			dataArr[i][1] = String.valueOf(bwlist.get(i).getBookId());
			Integer status = bwlist.get(i).getStatus();
			dataArr[i][2] = status == 1 ? "在借" : "已还";
	 		if(status == 1){
				dataArr[i][2] ="在借";
		    } else if (status == 2) {
			    dataArr[i][2] = "已还";
		    }
			Long borrowTime = bwlist.get(i).getBorrowTime();
			Long returnTime = bwlist.get(i).getReturnTime();
			dataArr[i][3] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(borrowTime));
			dataArr[i][4] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(returnTime));
		}
		// 然后实例化 上面2个控件对象
		model = new DefaultTableModel(dataArr, title);
		borrowTable = new JTable();
		borrowTable.setModel(model);


/*
		for (int i = 0; i < bwlist.size(); i++) {
			Integer id =bwlist.get(i).getId();
			Integer userId = bwlist.get(i).getUserId();
			Integer bookId = bwlist.get(i).getBookId();
			Integer status = bwlist.get(i).getStatus();
			Long borrowTime = bwlist.get(i).getBorrowTime();
			Long returnTime = bwlist.get(i).getReturnTime();
//			System.out.println(id);
			dates[i][0] = String.valueOf(id);
			dates[i][1] = String.valueOf(userId);
			dates[i][2] = String.valueOf(bookId);
//			状态  1在借2已还
			if(status == 1){
				dates[i][3] ="在借";
			}else if(status == 2){
				dates[i][3] ="已还";
			}
			dates[i][4]=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(borrowTime));
			dates[i][5]=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(returnTime));
		}

 */


		// 表格添加到滚动面板中，滚动面板添加到panel_1中，panel_1添加到jf中
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 607, 188);
		jscrollpane.setViewportView(borrowTable);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(315, 10, 197, 28);
//		User currentUser = LoginAdjust.currentUser;
		lblNewLabel_1.setText(currentUser.getUsername());

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
				//1:书籍名称
				//2.书籍作者
				DBInJ.fastPreparedExecuteQuery("SELECT book.*, book_type.type_name FROM book, book_type WHERE "
						+ (comboBox.getSelectedIndex() == 0 ? "book_name" : "author")
						+ " LIKE ? AND book.type_id = book_type.id", (ResultSet resultSet) -> {
					initializeBookTableData(resultSet);
					return null;
				}, "%" + textField_1.getText() + "%");



/*				// 闭包 函数
				Runnable z = () -> {
					System.out.println("111");
				};
				Consumer<String> c = System.out::println;
				c.accept("111");

				Function<Integer, Integer> func = new Function<>() {
					@Override
					public Integer apply(Integer o) {
						return o + 10;
					}
				};
				func.apply(5);*/

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
		String[] BookTitle = {"编号", "书名", "类型", "作者", "描述"};
		// 具体的各栏行记录 先用空的二位数组占位
		String[][] booklistArr = {};
		bookModel = new DefaultTableModel(booklistArr, BookTitle);
		bookTable = new JTable(bookModel);
		// 获取所有图书信息-------------------------------
		putDates(new Book());

		panel_2.setLayout(null);
		JScrollPane jscrollpane1 = new JScrollPane();
		jscrollpane1.setBounds(22, 74, 607, 250);
		jscrollpane1.setViewportView(bookTable);
		panel_2.add(jscrollpane1);
		jf.getContentPane().add(panel_1);
/*		// 借书面板
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
		panel_3.add(button_2);*/
		// 窗体背景图片
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UserMenuFrm.class.getResource("/tupian/uBG.png")));
		lblNewLabel_3.setBounds(0, 0, 684, 864);
		jf.getContentPane().add(lblNewLabel_3);

		btnBackBook.setVisible(false); // 隐藏还书按钮



		// 借书表格添加鼠标事件监听器
		bookTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 鼠标按下事件--------------待实现
				selectRow = bookTable.getSelectedRow();
				System.out.println(selectRow);
				borrowTable.clearSelection();
				if (selectRow != -1) {
					btnBackBook.setVisible(true);
					btnBackBook.setText("借书！");
				}
			}
		});

		// 退出按钮添加动作监听器
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 退出按钮单击事件-------------待实现

				selectRow = borrowTable.getSelectedRow();
				System.out.println(selectRow);
			}
		});

/*		btnBackBook.setText("借书");
		btnBackBook.setText("还书");*/
		// 还书按钮添加动作监听器
		btnBackBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 还书按钮单击事件-------------待实现
				if(btnBackBook.getText().equals("还书！")){
					System.out.println("还书按钮");
					Integer borrowDetailId =Integer.valueOf((String) borrowTable.getModel().getValueAt(selectRow,0));
					System.out.println(borrowDetailId);
					BorrowDetailDaoImpl sd = new BorrowDetailDaoImpl();
//					User getuser = sd.findByname(username);
					int row = sd.updateBorrowDetail(borrowDetailId,2);
					//还书完成
				}else if(btnBackBook.getText().equals("借书！")){
					System.out.println("借书按钮");
					Integer bookId = (Integer) bookTable.getModel().getValueAt(selectRow,0);
					System.out.println(bookId);
					borrowDetail nbw = new borrowDetail();
					nbw.setUserId(currentUser.getId());
					nbw.setBookId(bookId);
					nbw.setStatus(1);
					nbw.setBorrowTime(System.currentTimeMillis());
					BorrowDetailDaoImpl sd = new BorrowDetailDaoImpl();
					Boolean rb = sd.addBorrowDetail(nbw);
				}
			}
		});

		borrowTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				selectRow = borrowTable.getSelectedRow();
				System.out.println(selectRow);
				bookTable.clearSelection();
				if (selectRow != -1 && borrowTable.getModel().getValueAt(selectRow, 2).equals("在借")) {
					btnBackBook.setVisible(true);
					btnBackBook.setText("还书！");
				}else{
					btnBackBook.setVisible(false);
				}
			}
		});
		// 显示窗体，大小不可改变
		jf.setVisible(true);
		jf.setResizable(true);
	}

	/**
	 * 填充图书信息列表
	 * @param resultSet 返回集
	 * @throws SQLException 数据库异常
	 */
	private void initializeBookTableData(ResultSet resultSet) throws SQLException {
		TableModel model = bookTable.getModel();
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
				rowData.add(resultSet.getString("remark"));
				defaultTableModel.addRow(rowData);
			}
		}
	}

	private void putDates(Book book) {
		DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
		model.setRowCount(0);
		Connection connection = null;
		try {
			connection = JDBCUtils.getConn();
			book.setStatus(1);
			ResultSet list = BookDao.list(connection, book);
			while (list.next()) {
				Vector rowData = new Vector();
				rowData.add(list.getInt("id"));
				rowData.add(list.getString("book_name"));
				rowData.add(list.getString("type_name"));
				rowData.add(list.getString("author"));
				rowData.add(list.getString("remark"));
				model.addRow(rowData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		try {
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		LoginFrm.currentUser = new User();
		LoginFrm.currentUser.setId(1);
		new UserMenuFrm();
	}
}