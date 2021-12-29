package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.model.Book;
import com.seele0oO.jdbc.model.User;

import java.util.ArrayList;

public interface BookDao {
	ArrayList<Book> listByBookname();
	ArrayList<Book> listByBookauthor();
}
