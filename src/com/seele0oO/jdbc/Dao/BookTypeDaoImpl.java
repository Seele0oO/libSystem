package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.Unit.JDBCUtils;
import com.seele0oO.jdbc.model.bookType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookTypeDaoImpl {
	public ArrayList<bookType> findAllBookTypes() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<bookType> bookTypes = new ArrayList<bookType>(100);
		conn = JDBCUtils.getConn();
		String sql = "select * from book_type";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookType bT = new bookType();
				bT.setId(rs.getInt("id"));
				bT.setTypeName(rs.getString("type_name"));
				bT.setRemark(rs.getString("remark"));
				bookTypes.add(bT);
				bookTypes.size();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTypes;
	}
}
