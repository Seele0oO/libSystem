package com.seele0oO.jdbc.model;

public class bookType {
	private Integer id;
	private String typeName;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "bookType{" +
				"id=" + id +
				", typeName='" + typeName + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
