package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.Unit.JDBCUtils;
import com.seele0oO.jdbc.model.User;
import com.seele0oO.jdbc.model.borrowDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowDetailDaoImpl {
	public ArrayList<borrowDetail> getBorrowDetailList(Integer user_id){
		ArrayList<borrowDetail> list = new ArrayList<borrowDetail>();
		Connection conn = null;
		// Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
//            st= conn.createStatement();
			String sql = "select * from borrowdetail where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
//				Book book = new Book();
//				book.setBookname(rs.getString("bookname"));
//				book.setBookauther(rs.getString("bookauther"));
//				book.setBookcategory(rs.getString("bookcategory"));
//				book.setBookstats(rs.getString("bookstats"));
//				list.add(book);
				borrowDetail oldborrowDetail = new borrowDetail();
				oldborrowDetail.setId(rs.getInt("id"));
				oldborrowDetail.setUserId(rs.getInt("user_id"));
				oldborrowDetail.setBookId(rs.getInt("book_id"));
				oldborrowDetail.setStatus(rs.getInt("status"));
				oldborrowDetail.setBorrowTime(rs.getLong("borrow_time"));
				oldborrowDetail.setReturnTime(rs.getLong("return_time"));
//				oldborrowDetail.setborrowDetailname(rs.getString("borrowDetailname"));
//				oldborrowDetail.setPassword(rs.getString("password"));
//				oldborrowDetail.setRole(rs.getInt("role"));
//				oldborrowDetail.setSex(rs.getString("sex"));
//				oldborrowDetail.setPhone(rs.getString("phone"));
				list.add(oldborrowDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return list;
	}
}
