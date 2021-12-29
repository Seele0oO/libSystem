package com.seele0oO.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class AdminMenuFrm extends JFrame {
	private JFrame jf;					//图书类别添加窗体
	private JTextField textField;		//类别名称文本框
	private JButton btnNewButton;		//添加按钮
	private JTextArea textArea;			//类别详细信息文本域

	public AdminMenuFrm() {
		//初始化窗体组件
		jf = new JFrame("管理员界面");
		jf.setBounds(400, 100, 600, 429);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		//类别名称
		JLabel label = new JLabel();
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setText("类别说明：");
		label.setBounds(112, 107, 75, 26);
		jf.getContentPane().add(label);
		//类别说明
		JLabel label_1 = new JLabel();
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setText("类别名称：");
		label_1.setBounds(112, 38, 75, 26);
		jf.getContentPane().add(label_1);
		//类别名称文本框
		textField = new JTextField();
		textField.setBounds(197, 38, 241, 26);
		jf.getContentPane().add(textField);
		//添加按钮
		btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//添加按钮单击事件----------------待实现
				
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
		btnNewButton.setBounds(182, 281, 80, 26);
		jf.getContentPane().add(btnNewButton);
		//重置按钮
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//重置按钮单击事件----------------待实现
				
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 14));
		button.setBounds(360, 281, 80, 26);
		jf.getContentPane().add(button);
		//类别详细信息文本域
		textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setRows(5);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(197, 109, 241, 132);
		jf.getContentPane().add(textArea);
		//背景图片
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminMenuFrm.class.getResource("/tupian/adBG2.png")));
		lblNewLabel.setBounds(0, 0, 584, 370);
		jf.getContentPane().add(lblNewLabel);
		//菜单栏组件
		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		//添加类别管理菜单
		JMenu mnNewMenu = new JMenu("类别管理");
		menuBar.add(mnNewMenu);
		//添加类别添加菜单
		JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
		mnNewMenu.add(mntmNewMenuItem);
		//添加类别修改菜单
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//类别修改事件----------------待实现
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		//添加书籍管理菜单
		JMenu mnNewMenu_2 = new JMenu("书籍管理");
		menuBar.add(mnNewMenu_2);
		//添加书籍添加菜单项
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//书籍添加事件----------------待实现
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		//添加书籍修改菜单项
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//书籍修改事件-------------待实现
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		//添加用户管理菜单
		JMenu menu1 = new JMenu("用户管理");
		menuBar.add(menu1);
		//添加用户信息菜单项
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//用户信息事件-------------待实现
				
			}
		});
		menu1.add(mntmNewMenuItem_4);
		//添加借阅信息菜单项
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//借阅信息事件-------------待实现
				
			}
		});
		menu1.add(mntmNewMenuItem_5);
		//添加退出系统菜单
		JMenu mnNewMenu_1 = new JMenu("退出系统");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {			//退出系统事件-------------待实现
				// jf.dispose();
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_1);

		jf.setVisible(true);
		jf.setResizable(true);
	}

	protected void reset() {
		textField.setText("");
		textArea.setText("");
	}

	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new AdminMenuFrm();
	}
}
