package com.seele0oO.JFrame;

import com.seele0oO.jdbc.Dao.UserDaoImpl;
import com.seele0oO.jdbc.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

//import com.seele0oO.oldJDBC.*;
public class RegFrm extends JFrame {
	private JFrame jf; // 注册窗体组件
	private JLabel label; // 用户名
	private JTextField textField; // 用户名文本框
	private JLabel label_1; // 密码
	private JTextField textField_1; // 密码文本框
	private JLabel label_2; // 手机号
	private JTextField textField_2; // 手机号文本框
	private JLabel label_3; // 性别
	private JRadioButton rdbtnNewRadioButton; // 男单选按钮
	private JRadioButton rdbtnNewRadioButton_1; // 女单选按钮
	private JLabel usernameMes; // 用户名验证消息框
	private JLabel passwordMes; // 密码验证消息框
	private JLabel phoneMes; // 手机验证消息框
	private ValidCode vcode; // 验证码组件
	private JLabel label_4; // 验证码
	private JTextField textField_3; // 验证码文本框
	private JButton button; // 注册按钮
	private JButton button_1; // 前往登录页面按钮
	private JLabel lblNewLabel; // 背景图片
	private JLabel lblNewLabel_1; // 用户注册

	private Boolean check = false; 
	public RegFrm() {
		jf=new JFrame("用户注册");
		jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 16));
		jf.setBounds(600, 250,510, 410);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		label = new JLabel("用户名：");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		label.setBounds(110, 65, 75, 40);
		jf.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("幼圆", Font.BOLD, 14));
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(198, 71, 164, 30);
		jf.getContentPane().add(textField);
		
		textField.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent e) {      //用户名失去焦点----------------待实现
				//todo : add 在这里调用查找用户名
//				String username = textField.getText();
//				if (username.length()==0) {
//					usernameMes.setText("×");
//					check = false;
//				}else{
//					String temppassword = "0";
//
//					if (LoginAdjust.confirm(username, temppassword)==2) {
//						System.out.println("用户名合法");
//						usernameMes.setText("√");
//						check = true;
//					}else{
//						usernameMes.setText("×");
//						check = false;
//					}
//				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				usernameMes.setText("");
			}
		});
		
		label_1 = new JLabel("密码：");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("幼圆", Font.BOLD, 16));
		label_1.setBounds(120, 108, 65, 40);
		jf.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 14));
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(198, 114, 164, 30);
		jf.getContentPane().add(textField_1);
		//密码正则表达式：		^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
		textField_1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordMes.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String password = textField_1.getText();
				String pattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
				if (Pattern.matches(pattern,password)) {
					System.out.println("密码验证通过");
					passwordMes.setText("√");
					check = true; 
				}else{
					System.out.println("密码验证失败");
					passwordMes.setText("密码验证失败");
					passwordMes.setText("×");
					check = false; 
					
				}
			}
		});
			

		
		label_2 = new JLabel("手机号：");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("幼圆", Font.BOLD, 16));
		label_2.setBounds(110, 150, 75, 40);
		jf.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(198, 156, 164, 30);
		jf.getContentPane().add(textField_2);
		//手机号正则表达式：		^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$
		textField_2.addFocusListener(new FocusListener() {	
			@Override
			public void focusLost(FocusEvent e) {
						//手机号失去焦点----------------待实现
						check = false; 
						String phone = textField_2.getText();
						String pattern = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
						if (Pattern.matches(pattern,phone)) {
							System.out.println("手机号验证通过");
							phoneMes.setText("√");
							check = true; 
						}else{
							System.out.println("手机号验证失败");
							phoneMes.setText("手机号不合法");
							check = false; 
						}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				phoneMes.setText("");
			}
		});
		
		label_3 = new JLabel("性别：");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("幼圆", Font.BOLD, 16));
		label_3.setBounds(123, 184, 65, 40);
		jf.getContentPane().add(label_3);
		
		rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setFont(new Font("幼圆", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
		jf.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(287, 192, 65, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_1);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);

		usernameMes = new JLabel("");
		usernameMes.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameMes.setBounds(372, 70, 122, 27);
		jf.getContentPane().add(usernameMes);
		
		passwordMes = new JLabel("");
		passwordMes.setFont(new Font("Dialog", Font.BOLD, 15));
		passwordMes.setBounds(372, 114, 122, 27);
		jf.getContentPane().add(passwordMes);
		
		phoneMes = new JLabel("");
		phoneMes.setFont(new Font("Dialog", Font.BOLD, 15));
		phoneMes.setBounds(372, 152, 122, 30);
		jf.getContentPane().add(phoneMes);

		vcode=new ValidCode();
		vcode.setLocation(293, 231);
		jf.getContentPane().add(vcode);
		
		label_4 = new JLabel("验证码：");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("幼圆", Font.BOLD, 16));
		label_4.setBounds(110, 231, 75, 40);
		jf.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 241, 83, 30);
		jf.getContentPane().add(textField_3);
		
		button = new JButton("注册");
		
		button.addActionListener(new ActionListener() {			//注册按钮单击事件----------------待实现
			public void actionPerformed(ActionEvent e) {
			String username = textField.getText();
			String password = textField_1.getText();
			String sex = null;
			Integer role = 0;
			// String sex = textField_2
			if(rdbtnNewRadioButton.isSelected()){
				sex = "男";
			}else if (rdbtnNewRadioButton_1.isSelected()){
				sex = "女";
				System.out.println(sex);
			}
			String phone = textField_2.getText();
			
			if (textField_3.getText().equalsIgnoreCase(vcode.getCode())) {
				check = true; 
			}else{
				check = false; 
				JOptionPane.showMessageDialog(null,"请重新输入验证码");
			}

			if (check) {
				Boolean res = reg(username,password,sex,phone);//在下面
				if (res) {
					JOptionPane.showMessageDialog(null,"注册成功");
				}else{
					JOptionPane.showMessageDialog(null,"注册失败,请联系数据库管理员");
				}
			}else{
				JOptionPane.showMessageDialog(null, "检查未通过");
			}
			// System.out.println(username);
			}

			private Boolean reg(String username, String password, String sex, String phone) {
				UserDaoImpl sd = new UserDaoImpl();
				Boolean rsr;
				User newUser = new User();
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setSex(sex);
				newUser.setPhone(phone);
				Integer row =  sd.addUser(newUser);
				if (row ==1){
					 rsr = true;
				}else{
					 rsr = false;
				}
				return rsr;
			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 15));
		button.setBounds(120, 299, 75, 30);
		jf.getContentPane().add(button);
		
		button_1 = new JButton("前往登录页面");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//前往登录页面按钮单击事件----------待实现
				jf.dispose();
                new LoginFrm();
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 15));
		button_1.setBounds(245, 299, 132, 30);
		jf.getContentPane().add(button_1);
		
		lblNewLabel_1 = new JLabel("用户注册");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setBounds(184, 10, 122, 51);
		jf.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(RegFrm.class.getResource("/tupian/regBG.png")));
		lblNewLabel.setBounds(0, 0, 494, 372);
		jf.getContentPane().add(lblNewLabel);
		
		jf.setVisible(true);
		jf.setResizable(true);
	}



	public static void main(String[] args) {
		/*
		 * try {
		 * BeautyEyeLNFHelper.frameBorderStyle =
		 * BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
		 * org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		 * } catch (Exception e) {
		 * e.printStackTrace();
		 * }
		 */
		new RegFrm();
	}
}
