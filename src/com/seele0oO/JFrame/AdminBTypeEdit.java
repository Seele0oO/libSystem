package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Unit.DBInJ;

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
import java.util.Vector;

public class AdminBTypeEdit extends JFrame {
	private JFrame jf;// 类别修改窗体
	private JTable table;// 类别信息表格组件
	private DefaultTableModel model;// 类别信息表格数据模型组件
	private JTextField textField;// 类别编号文本框
	private JTextField textField_1;// 类别名称文本框
	private JTextField textField_2;// 类别描述信息文本框
	private Integer selectRow;

	private Boolean canDel;

	public AdminBTypeEdit() {
		// 初始化类别修改窗体
		jf = new JFrame("管理员界面");
		jf.setBounds(400, 100, 611, 472);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		// 创建菜单栏
		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		// 添加类别管理菜单
		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);
		// 添加类别添加菜单项
		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {// 类别添加事件-------------
				jf.dispose();
				new AdminMenuFrm();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		// 添加类别修改菜单项
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mnNewMenu.add(mntmNewMenuItem_1);
		// 添加书籍管理菜单
		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);
		// 添加书籍添加菜单项
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {// 书籍添加事件---------------
				jf.dispose();
				new AdminBookAdd();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		// 添加书籍修改菜单项
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 书籍修改事件--------------
				jf.dispose();
				new AdminBookEdit();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		// 添加用户管理菜单
		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);
		// 添加用户信息菜单项
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { // 用户信息事件---------------
				jf.dispose();
				new AdminUserInfo();
			}
		});
		menu1.add(mntmNewMenuItem_4);
		// 添加借阅信息菜单项
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {// 借阅信息事件--------------
				jf.dispose();
				new AdminBorrowInfo();
			}
		});
		menu1.add(mntmNewMenuItem_5);
		// 添加退出系统
		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {// 退出系统事件---------------
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "类别信息", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(20, 10, 554, 208);

		/*
		 * 做一个表头栏数据 一位数组
		 */
		String[] title = { "编号", "类别名称", "类别描述" };
		/* 具体的各栏行记录 先用空的二位数组占位 */
		String[][] dates = {};
		/* 然后实例化 上面2个控件对象 */
		model = new DefaultTableModel(dates, title);
		table = new JTable(model);
		// 获取数据库图书类别数据放置table中---------------------待实现
		panel_1.setLayout(null);
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(20, 22, 517, 163);
		jscrollpane.setViewportView(table);
		panel_1.add(jscrollpane);
		jf.getContentPane().add(panel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "类别编辑", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(20, 228, 554, 168);
		jf.getContentPane().add(panel);
		panel.setLayout(null);


		DBInJ.fastPreparedExecuteQuery("SELECT * FROM book_type ", (ResultSet resultSet) -> {
					initializeBookTypeTableData(resultSet);
					return null;
				}
		);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { //鼠标监听事件------------------------待实现

				selectRow = table.getSelectedRow();

				selectRow = table.getSelectedRow();
				var InTableid = table.getModel().getValueAt(selectRow, 0);
				var InTableTypeName = table.getModel().getValueAt(selectRow, 1);
				var InTableRemark = table.getModel().getValueAt(selectRow, 2);
				textField.setText(String.valueOf(InTableid));
				textField_1.setText(String.valueOf(InTableTypeName));
				textField_2.setText(String.valueOf(InTableRemark));
			}
		});

		JLabel lblNewLabel = new JLabel("编号：");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 14));
		lblNewLabel.setBounds(73, 26, 45, 28);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(116, 30, 92, 24);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("类别名称：");
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setBounds(238, 26, 75, 28);
		panel.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(314, 30, 122, 24);
		panel.add(textField_1);

		JLabel label_1 = new JLabel("描述：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setBounds(73, 65, 45, 28);
		panel.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 69, 320, 24);
		panel.add(textField_2);

		JButton btnNewButton = new JButton("修改");
		// 类别修改
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//修改按钮单击事件---------------------
				Integer id = (Integer) table.getModel().getValueAt(selectRow, 0);
				Integer typename = (Integer) table.getModel().getValueAt(selectRow, 0);
				Integer remark = (Integer) table.getModel().getValueAt(selectRow, 0);

				int i = DBInJ.fastPreparedExecuteUpdate("UPDATE book_type SET typ" +
						"ename = ?,remark = ?", typename, remark);
				if (i == 1) {
					JOptionPane.showMessageDialog(null, "修改成功");
				}
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton.setBounds(128, 117, 93, 28);
		panel.add(btnNewButton);

		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//删除按钮单击事件----------------------
				Integer id = (Integer) table.getModel().getValueAt(selectRow, 0);
				DBInJ.fastPreparedExecuteQuery("SELECT * FROM book WHERE type_id = ?", (ResultSet resultSet) -> {
					if (resultSet.next()) {
						canDel = false;
					} else {
						canDel = true;
					}
					return null;
				}, id);
				if (canDel) {
					boolean b = DBInJ.fastPreparedExecute("DELETE FROM book_type WHERE id = ?", id);
					if (!b) {
						JOptionPane.showMessageDialog(null, "删除成功");
					}
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 14));
		button.setBounds(314, 117, 93, 28);
		panel.add(button);
		//背景图片
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminBTypeEdit.class.getResource("/tupian/adBG3.png")));
		lblNewLabel_1.setBounds(0, 0, 595, 413);
		jf.getContentPane().add(lblNewLabel_1);

		jf.setVisible(true);
		jf.setResizable(true);
	}

	private void initializeBookTypeTableData(ResultSet resultSet) {
		TableModel model = table.getModel();
		if (model instanceof DefaultTableModel defaultTableModel) {
			defaultTableModel.setRowCount(0);
			while (true) {
				try {
					if (!resultSet.next()) break;
					Vector<Object> rowData = new Vector<>();
					rowData.add(resultSet.getInt("id"));
					rowData.add(resultSet.getString("type_name"));
					rowData.add(resultSet.getString("remark"));
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
		new AdminBTypeEdit();
	}
}
