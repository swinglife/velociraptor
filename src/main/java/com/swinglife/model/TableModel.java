package com.swinglife.model;

/****
 * 
 * @author Swing
 * 
 */
public class TableModel {
	private String tableName;
	private String typeName;
	private String columnName;
	private String upTableName;
	private String upColumnName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getUpTableName() {
		return upTableName;
	}

	public void setUpTableName(String upTableName) {
		this.upTableName = upTableName;
	}

	public String getUpColumnName() {
		return upColumnName;
	}

	public void setUpColumnName(String upColumnName) {
		this.upColumnName = upColumnName;
	}

}
