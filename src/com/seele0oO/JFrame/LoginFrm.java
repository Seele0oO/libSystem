package com.seele0oO.JFrame;


import com.seele0oO.jdbc.Dao.UserDaoImpl;
import com.seele0oO.jdbc.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrm extends JFrame {
//	public static User currentUser; // 当前登录用户
	private JFrame jf; // 登录窗体
	private JTextField userNameText; // 用户名文本框
	private JTextField passwordText; // 密码文本框
	private JComboBox<String> comboBox; // 用户角色下拉组合框

	public LoginFrm() {

		jf = new JFrame("图书管理");
		jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 14));
		jf.setBounds(600, 250, 500, 467);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(LoginFrm.class.getResource("/tupian/bg2.png")));
		lblNewLabel.setBounds(24, 10, 430, 218);
		jf.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setBounds(129, 250, 60, 29);
		jf.getContentPane().add(label);

		userNameText = new JTextField();
		userNameText.setBounds(199, 252, 127, 25);
		jf.getContentPane().add(userNameText);
		userNameText.setColumns(10);

		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setBounds(144, 289, 45, 29);
		jf.getContentPane().add(label_1);

		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(199, 291, 127, 25);
		jf.getContentPane().add(passwordText);

		JLabel label_2 = new JLabel("权限：");
		label_2.setFont(new Font("幼圆", Font.BOLD, 14));
		label_2.setBounds(144, 328, 45, 29);
		jf.getContentPane().add(label_2);

		comboBox = new JComboBox();
		comboBox.setBounds(199, 332, 127, 25);
		comboBox.addItem("用户");
		comboBox.addItem("管理员");
		jf.getContentPane().add(comboBox);

		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() { // 登录按钮单击事件-----------------待实现
			public void actionPerformed(ActionEvent e) {
				String username = userNameText.getText();
				String password = passwordText.getText();
				Boolean isAdmin = null; // 1,false,2,true
				int loginstatus = -1;
//				Integer loginstatus = LoginFrmFun.loginFrmLoginButtonOnclick(username, password, isAdmin);
				//currentUser = username;
//				System.out.println(loginstatus);
				UserDaoImpl sd = new UserDaoImpl();
				User getuser = sd.findByname(username);


				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "未填写完成");
				} else {
					if (getuser.getPassword() == null) {
//						JOptionPane.showMessageDialog(null, "未注册");
						loginstatus=2;
					} else {
						if (getuser.getPassword().equals(password)) {
							loginstatus = 0;
							if (getuser.getRole() == 1) {
								isAdmin = false;//user
							} else if (getuser.getRole() == 2) {
								isAdmin = true;
							}
						} else {
							loginstatus = 1;
						}
					}
					switch (loginstatus) {
						case 0:
							// login success
							JOptionPane.showMessageDialog(null, "登录成功");
							// -------------------------------------------------------------------------------------------------------------------------------------------------//
							if (comboBox.getSelectedIndex() == 1) {
								// user login
								// isadmin true->> AdminMenuFrm
								if (isAdmin) {
									jf.dispose();
									new AdminMenuFrm();
								} else {
									JOptionPane.showMessageDialog(null, "权限验证失败");
								}
							} else if (comboBox.getSelectedIndex() == 0) {
								// admin login
								jf.dispose();
								new UserMenuFrm();

							}
							break;
						case 1:
							// 密码错误
							JOptionPane.showMessageDialog(null, "登录失败");
							break;
						case 2:
							// 未注册
							JOptionPane.showMessageDialog(null, "未注册");
							break;
					}
				}

			}
		});
		button.setBounds(153, 377, 65, 29);
		jf.getContentPane().add(button);

		JButton button_1 = new JButton("注册"); // 注册按钮单击事件-----------------待实现
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new RegFrm();
			}
		});
		button_1.setBounds(263, 377, 65, 29);
		jf.getContentPane().add(button_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/tupian/adBG3.png")));
		lblNewLabel_1.setBounds(0, 0, 484, 429);
		jf.getContentPane().add(lblNewLabel_1);
		jf.setVisible(true);
		jf.setResizable(true);
	}

	protected void regUser(ActionEvent e) {
		jf.setVisible(false);
		new RegFrm();
	}

	public static void main(String[] args) {
		// try {
		// BeautyEyeLNFHelper.frameBorderStyle =
		// BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		new LoginFrm();
	}
}
