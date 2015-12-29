package com.swinglife.utils;

import com.swinglife.model.DBInfoModel;

import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
	public static Properties prop;

	public static void main(String[] args) {
		DBInfoModel dBinfoModel = new DBInfoModel();
		dBinfoModel.setDataName("daxidi");
		dBinfoModel.setDriver("com.mysql.jdbc.Driver");
		dBinfoModel.setPassword("123456");
		dBinfoModel.setUserName("root");
		dBinfoModel.setUrl("jdbc:mysql://localhost:3306/daxidi?useUnicode=true&characterEncoding=utf-8");
		Connection conn = getConnection(dBinfoModel);
		System.out.println(conn);
	}

	public static Connection getConnection(DBInfoModel dBinfoModel)
	{
		System.out.println(dBinfoModel.getDataName());
		Connection con = null;
		try
		{
			Class.forName(dBinfoModel.getDriver());
			con = DriverManager.getConnection(dBinfoModel.getUrl(), dBinfoModel.getUserName(), dBinfoModel.getPassword());
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (stmt != null)
		{
			try
			{
				stmt.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
