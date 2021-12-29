package com.seele0oO.oldJDBC.dao;

public interface BookDao {
	ArrayList<Book> findAll();
	Book findByname(String name);
	int insertBook(Book book);
	int updataBook(Book book);
	int deleteBook(String name) ;
}