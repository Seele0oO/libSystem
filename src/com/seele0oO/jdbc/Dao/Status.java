package com.seele0oO.jdbc.Dao;

public enum Status {

	XXX("在借"),
	YYY("已换");
	public final String chineseName;

	Status(String chineseName) {
		this.chineseName = chineseName;
	}
}
