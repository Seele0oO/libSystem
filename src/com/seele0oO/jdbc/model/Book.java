package com.seele0oO.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
	private Integer id;
	private String bookName;
	private Integer typeId;
	private String author;
	private String publish;
	private Double price;
	private Integer number;
	private Integer status;
	private String remark;

	public static Book initializeByResultSet(ResultSet rs)
	{
		Book book = new Book();
		try {
			book.id = rs.getInt("id");
			book.bookName = rs.getString("book_name");
			book.typeId = rs.getInt("type_id");
			book.author = rs.getString("author");
			book.publish = rs.getString("publish");
			book.price = rs.getDouble("price");
			book.number = rs.getInt("number");
			book.status = rs.getInt("status");
			book.remark = rs.getString("remark");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", bookName='" + bookName + '\'' +
				", typeId=" + typeId +
				", author='" + author + '\'' +
				", publish='" + publish + '\'' +
				", price=" + price +
				", number=" + number +
				", status=" + status +
				", remark='" + remark + '\'' +
				'}';
	}

}
