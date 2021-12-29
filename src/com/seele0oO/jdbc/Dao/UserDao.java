package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.model.User;

import java.util.ArrayList;

public interface UserDao {
//	ArrayList<Book> findAll();
//	Book findByname(String name);
//	int insertBook(Book book);
//	int updataBook(Book book);
//	int deleteBook(String name) ;
	ArrayList<User> listAll();
	User findByname(String username);
	Integer addUser(User user);
}
