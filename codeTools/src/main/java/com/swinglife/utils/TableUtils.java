package com.swinglife.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.swinglife.model.ModelField;

import com.swinglife.model.DBInfoModel;

public class TableUtils {
	private Connection conn = null;
	private String dataName = null;
	private ResultSet rs;
	private Statement stmt;

	public TableUtils() {
		DBInfoModel dBinfoModel = new DBInfoModel();
		dBinfoModel.setDataName("tcpf");
		dBinfoModel.setDriver("com.mysql.jdbc.Driver");
		dBinfoModel.setPassword("123456");
		dBinfoModel.setUserName("root");
		dBinfoModel.setUrl("jdbc:mysql://localhost:3306/tcpf?useUnicode=true&characterEncoding=utf-8");
		this.conn = JDBCUtils.getConnection(dBinfoModel);
		this.dataName = dBinfoModel.getDataName();
	}

	public TableUtils(DBInfoModel dBinfoModel) {
		this.conn = JDBCUtils.getConnection(dBinfoModel);
		this.dataName = dBinfoModel.getDataName();
		System.out.println(this.conn);
	}

	public Map getColumn() throws SQLException {
		List tableList = this.getTableName();
		stmt = conn.createStatement();
		Map<String, String> map = new HashMap();
		for (int i = 0; i < tableList.size(); i++) {
			String tableName = (String) tableList.get(i);
			ResultSet rs = stmt.executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int j = 1; j < rsmd.getColumnCount(); j++) {
				System.out.println("");
				map.put(rsmd.getColumnTypeName(j) + "[" + j + "]", rsmd.getColumnName(j));
				System.out.println(j);
			}
		}
		System.out.println(map.size());

		return map;
	}

	public List getTableName() throws SQLException {
		List columnList = new ArrayList();
		// 得到数据库表返回
		rs = getMetaData().getTables(getCatalogName(), "%", "%", new String[] { "TABLE" });
		while (rs.next()) {
			// 循环添加到list中
			columnList.add(rs.getString("TABLE_NAME"));
		}
		return columnList;
	}

	private String getCatalogName() {
		String catalog = "";
		List tableList = getAllCatalogs();
		for (int i = 0; i < tableList.size(); i++) {
			catalog = (String) tableList.get(i);
			if ((dataName != null) && !dataName.equalsIgnoreCase(catalog))
				continue;
			return catalog;
		}
		return null;
	}

	private DatabaseMetaData getMetaData() throws SQLException {
		// 创建数据库元数据
		DatabaseMetaData metaData = conn.getMetaData();
		return metaData;
	}

	/***
	 * 获得数据库列表
	 */
	private List getAllCatalogs() {
		List tableList = new ArrayList();
		try {
			// 获得数据库目录
			rs = getMetaData().getCatalogs();
			// 将目录添加到list中
			while (rs.next()) {
				tableList.add(rs.getString("TABLE_CAT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableList;
	}

	public List getColumnType(String tableName) throws Exception {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		ResultSetMetaData rsmd = rs.getMetaData();
		List columnTypeList = new ArrayList();
		for (int j = 1; j < rsmd.getColumnCount(); j++) {
			// columnTypeList.add(Config.toJavaType(rsmd.getColumnTypeName(j)));
			columnTypeList.add(JavaType.getType(rsmd, rsmd.getColumnName(j)));
			// System.out.print();
		}

		return columnTypeList;
	}

	public List getColumnName(String tableName) throws Exception {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		ResultSetMetaData rsmd = rs.getMetaData();
		List columnList = new ArrayList();
		for (int j = 1; j < rsmd.getColumnCount(); j++) {
			columnList.add(rsmd.getColumnName(j));
		}
		return columnList;
	}

	public List getComment(String tableName) throws SQLException {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("show full columns from " + tableName);
		List columnList = new ArrayList();
		while (rs.next()) {
			String comment = rs.getString("Comment");
			columnList.add(comment);
		}
		return columnList;
	}

	public List<ModelField> getTableModel(String tableName) throws Exception {
		List<ModelField> listTableModel = new ArrayList();
		// 获得列名，类型名，添加到tablemodel中
		List<String> listColumnName = this.getColumnName(tableName);
		List<String> listColumnType = this.getColumnType(tableName);
		List<String> remarks = this.getComment(tableName);
		for (int i = 0; i < listColumnName.size(); i++) {
			ModelField tableMode = new ModelField();
			tableMode.setColumnName(listColumnName.get(i));
			tableMode.setType(listColumnType.get(i));
			tableMode.setRemark(remarks.get(i));
			String strs[] = listColumnName.get(i).split("_");
			String str = "";
			if (strs != null && strs.length > 0) {
				for (int j = 0; j < strs.length; j++) {
					if (j != 0) {
						str = str + Format.toIndexUp(strs[j]);
					} else {
						str = str + strs[j];
					}
				}
				tableMode.setName(str);
			} else {
				tableMode.setName(listColumnName.get(i));
			}
			String index = tableMode.getName().substring(0, 1).toUpperCase();
			tableMode.setUpName(index + tableMode.getName().substring(1, tableMode.getName().length()));
			listTableModel.add(tableMode);
		}
		return listTableModel;
	}

	public static void main(String[] args) throws Exception {
		TableUtils t = new TableUtils();
		List<String> list = t.getTableName();
		for (String s : list) {
			System.out.println(s);
		}
		/*
		 * for (int i = 0; i < list.size(); i++) { List<TableModel> b =
		 * a.getTableModel(list.get(i)); for (TableModel t : b) {
		 * System.out.println("--------------表:" + t.getUpTableName() +
		 * "---------------"); System.out.println("名称:" + t.getColumnName() +
		 * "----" + "类型:" + t.getTypeName());
		 * System.out.println(t.getUpColumnName()); } }
		 */
	}
	
	/***
	 * 根据tableName 获取model名称
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getModelName(String tableName) {
		if (tableName == null) {
			return null;
		}
		tableName = tableName.substring(2, tableName.length());
		String strs[] = tableName.split("_");
		StringBuffer modelName = new StringBuffer();
		for (String str : strs) {
			String index = str.substring(0, 1).toUpperCase();
			modelName.append(index + str.substring(1, str.length()));
		}
		return modelName.toString();
	}
}
