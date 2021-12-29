package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.Unit.JDBCUtils;
import com.seele0oO.jdbc.model.Book;
import com.seele0oO.jdbc.model.borrowDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDaoImpl {
	public ArrayList<Book> listByBookname(String bookName) {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from book where book_name like ?";
			//bookname前后各有一个% 用来模糊查询
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("book_name"));
				book.setTypeId(rs.getInt("type_id"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPrice(rs.getDouble("price"));
				book.setNumber(rs.getInt("number"));
				book.setStatus(rs.getInt("status"));
				book.setRemark(rs.getString("remark"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return list;
	}
	public ArrayList<Book> listByBookauthor(String author) {
		ArrayList<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select * from book where author like ?";
			//bookname前后各有一个% 用来模糊查询
			ps = conn.prepareStatement(sql);
			ps.setString(1, author);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("book_name"));
				book.setTypeId(rs.getInt("type_id"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPrice(rs.getDouble("price"));
				book.setNumber(rs.getInt("number"));
				book.setStatus(rs.getInt("status"));
				book.setRemark(rs.getString("remark"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return list;
	}
}
