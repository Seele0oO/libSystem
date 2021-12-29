package com.seele0oO.oldJDBC.dao;

import com.seele0oO.oldJDBC.model.User;
import com.seele0oO.oldJDBC.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimpl {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	//查找指定用户是否存在
	public boolean findByName(String uname) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from user where username=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return flag;
	}

	//插入一个user
	public int addUser(User user) {
		int i = 0;
		if (findByName(user.getUserName())) {
			return 2;
		}
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into values(NULL,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRole());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPhone());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps);
		}
		return i;
	}
}
