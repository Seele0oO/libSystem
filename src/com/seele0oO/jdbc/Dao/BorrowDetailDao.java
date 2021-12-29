package com.seele0oO.jdbc.Dao;

import com.seele0oO.jdbc.model.borrowDetail;

import java.util.ArrayList;

public interface BorrowDetailDao {
	ArrayList<borrowDetail> getBorrowDetailList();
	Integer updateBorrowDetail(Integer id,Integer status);
	Boolean addBorrowDetail(borrowDetail nbw);
}
