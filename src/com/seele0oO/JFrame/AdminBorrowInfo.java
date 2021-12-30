package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Dao.BookDaoImpl;
import com.seele0oO.jdbc.Dao.UserDaoImpl;
import com.seele0oO.jdbc.Unit.DBInJ;
import com.seele0oO.jdbc.model.Book;
import com.seele0oO.jdbc.model.User;

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
			public void mousePressed(MouseEvent evt) {		//退出系统事件-----------------------待实现
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "借阅信息", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(10, 10, 574, 350);


		DBInJ.fastPreparedExecuteQuery("SELECT * FROM borrowdetail ", (ResultSet resultSet) -> {
					initializeBorrowDetailTableData(resultSet);
					return null;
				}
		);



		/*
		 * 做一个表头栏数据 一位数组
		 */
		String[] title = {"借书人", "书名", "状态", "借书时间", "还书时间"};
		/* 具体的各栏行记录 先用空的二位数组占位 */
		String[][] dates = {};
		/* 然后实例化 上面2个控件对象 */
		model = new DefaultTableModel(dates, title);
		table = new JTable(model);
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

	private void initializeBorrowDetailTableData(ResultSet resultSet) {
		TableModel model = table.getModel();
		if (model instanceof DefaultTableModel defaultTableModel) {
			defaultTableModel.setRowCount(0);
			while (true) {
				try {
					if (!resultSet.next()) break;
					Vector<Object> rowData = new Vector<>();
					UserDaoImpl sd = new UserDaoImpl();
					User user = sd.findByUserID(resultSet.getInt("user_id"));

					BookDaoImpl bd = new BookDaoImpl();
					Book book = bd.findByBookId(resultSet.getInt("book_id"));


					rowData.add(user.getUsername());
					rowData.add(book.getBookName());

//					DBInJ.fastPreparedExecute("SELECT status from borrowdetail where")
					if (resultSet.getInt("status") == 1) {
						rowData.add("在借");
					} else {
						rowData.add("已还");
					}

					String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(resultSet.getInt("borrow_time")));
					rowData.add(date);

					String returnDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(resultSet.getInt("return_time")));
					rowData.add(returnDate);
//					rowData.add(resultSet.getString("remark"));
					defaultTableModel.addRow(rowData);
					System.out.println(rowData);
				} catch (SQLException e) {
					e.printStackTrace();
				}

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
