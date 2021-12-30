package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.model.Book;
import com.seele0oO.jdbc.model.bookType;

import java.util.ArrayList;

public interface BookTypeDao {
	ArrayList<bookType> findAllBookTypes();
}
