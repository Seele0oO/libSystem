package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.Unit.JDBCUtils;
import com.seele0oO.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl {
	public ArrayList<User> findAll(){
		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		// Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
//            st= conn.createStatement();
			String sql = "select * from user ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
//				Book book = new Book();
//				book.setBookname(rs.getString("bookname"));
//				book.setBookauther(rs.getString("bookauther"));
//				book.setBookcategory(rs.getString("bookcategory"));
//				book.setBookstats(rs.getString("bookstats"));
//				list.add(book);
				User oldUser = new User();
				oldUser.setId(rs.getInt("id"));
				oldUser.setUsername(rs.getString("username"));
				oldUser.setPassword(rs.getString("password"));
				oldUser.setRole(rs.getInt("role"));
				oldUser.setSex(rs.getString("sex"));
				oldUser.setPhone(rs.getString("phone"));
				list.add(oldUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return list;
	}

	public User findByname (String username){
		Connection conn = null;
		// Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User oldUser = new User();
		try {
			conn = JDBCUtils.getConn();
//            st= conn.createStatement();
			String sql = "select * from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();

			while (rs.next()) {

				oldUser.setId(rs.getInt("id"));
				oldUser.setUsername(rs.getString("username"));
				oldUser.setPassword(rs.getString("password"));
				oldUser.setRole(rs.getInt("role"));
				oldUser.setSex(rs.getString("sex"));
				oldUser.setPhone(rs.getString("phone"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

			return oldUser;
	}
	public Integer addUser (User newUser){
		Connection conn = null;
		// Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer row = 0;
		User oldUser = new User();
		conn = JDBCUtils.getConn();
//            st= conn.createStatement();
		String sql = "INSERT INTO user(username,password,sex,phone) VALUES (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,newUser.getUsername());
			ps.setString(2,newUser.getPassword());
			ps.setString(3,newUser.getSex());
			ps.setString(4,newUser.getPhone());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
