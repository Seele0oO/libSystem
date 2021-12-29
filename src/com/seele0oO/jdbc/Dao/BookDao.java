package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.Unit.ToolUtil;
import com.seele0oO.jdbc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface BookDao {
	static ResultSet list(Connection connection, Book book) throws Exception {
		StringBuffer sb = new StringBuffer("SELECT b.* , bt.type_name FROM book b , book_type bt WHERE b.type_id = bt.id");
		if (!ToolUtil.isEmpty(book.getBookName())) {
			sb.append(" and b.book_name like '%" + book.getBookName() + "%'");
		}
		if (!ToolUtil.isEmpty(book.getAuthor())) {
			sb.append(" and b.book_name like '%" + book.getAuthor() + "%'");
		}
		if (book.getTypeId() != null && book.getTypeId() != 0) {
			sb.append(" and b.type_id=" + book.getTypeId());
		}

		if (book.getStatus() != null) {

			sb.append(" and b.status = " + book.getStatus());
		}

		if (book.getId() != null) {

			sb.append(" and b.id = " + book.getId());

		}
		sb.append(" order by b.status");
		PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
		return preparedStatement.executeQuery();


	}

	ArrayList<Book> listByBookname();

	ArrayList<Book> listByBookauthor();
}
