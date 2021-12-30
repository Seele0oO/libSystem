package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Unit.DBInJ;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class AdminBorrowInfo extends JFrame {
	private JFrame jf;//借阅信息窗体
	private JTable table;//借阅信息数据表格
	private DefaultTableModel model;//借阅信息数据表格的数据模型

	public AdminBorrowInfo() {
		jf = new JFrame("管理员界面");
		jf.setBounds(400, 100, 610, 441);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //类别添加事件-----------------------待实现
				jf.dispose();
				new AdminMenuFrm();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //类别修改事件-----------------------待实现
				jf.dispose();
				new AdminBTypeEdit();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //书籍添加事件-----------------------待实现
				jf.dispose();
				new AdminBookAdd();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //书籍修改事件-----------------------待实现
				jf.dispose();
				new AdminBookEdit();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //用户信息事件-----------------------待实现
				jf.dispose();
				new AdminUserInfo();
			}
		});
		menu1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		menu1.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {        //退出系统事件-----------------------待实现
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_1);

		String[] title = {"借书人", "书名", "状态", "借书时间", "还书时间"};
		/* 具体的各栏行记录 先用空的二位数组占位 */
		String[][] dates = {};
		/* 然后实例化 上面2个控件对象 */
		model = new DefaultTableModel(dates, title);
		table = new JTable(model);


		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "借阅信息", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(10, 10, 574, 350);


		String sql = "SELECT\n" +
				"\tborrowdetail.*,\n" +
				"\tUSER.id uid,\n" +
				"\tUSER.username,\n" +
				"\tbook.id bid,\n" +
				"\tbook.book_name \n" +
				"FROM\n" +
				"\tborrowdetail,\n" +
				"\tUSER,\n" +
				"\tbook \n" +
				"WHERE\n" +
				"\tbook.id = borrowdetail.book_id \n" +
				"\tAND USER.id = borrowdetail.user_id;";
//		System.out.println(sql);
		DBInJ.fastPreparedExecuteQuery(sql,(ResultSet resultSet) -> {
			initializeBookTableData(resultSet);
			return null;
		});
		/*public void actionPerformed(ActionEvent e) { // 查询按钮单击事件----------------待实现
			//1:书籍名称
			//2.书籍作者
			DBInJ.fastPreparedExecuteQuery("SELECT book.*, book_type.type_name FROM book, book_type WHERE "
					+ (comboBox.getSelectedIndex() == 0 ? "book_name" : "author")
					+ " LIKE ? AND book.type_id = book_type.id", (ResultSet resultSet) -> {
				initializeBookTableData(resultSet);
				return null;
			}, "%" + textField_1.getText() + "%");



*//*				// 闭包 函数
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
				func.apply(5);*//*

		}
*/



		/*
		 * 做一个表头栏数据 一位数组
		 */

		// 获取数据库数据放置table中--------------------------------------待实现
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 538, 314);
		jscrollpane.setViewportView(table);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminBorrowInfo.class.getResource("/tupian/adBG2.png")));
		lblNewLabel.setBounds(0, 0, 584, 379);
		jf.getContentPane().add(lblNewLabel);

		jf.setVisible(true);
		jf.setResizable(true);
	}

	private void initializeBookTableData(ResultSet resultSet) throws SQLException {
		TableModel model = table.getModel();
		if (model instanceof DefaultTableModel defaultTableModel)
		{
			defaultTableModel.setRowCount(0);
			while (resultSet.next())
			{
				Vector<Object> rowData = new Vector<>();
				rowData.add(resultSet.getString("username"));
				rowData.add(resultSet.getString("book_name"));
				rowData.add(resultSet.getInt("status"));
				rowData.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(resultSet.getLong("borrow_time"))));
				rowData.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(resultSet.getLong("return_time"))));
				defaultTableModel.addRow(rowData);
			}
		}
	}


	public static void main(String[] args) {
/*		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		new AdminBorrowInfo();
	}
}
