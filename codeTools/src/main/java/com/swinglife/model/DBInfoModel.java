package com.swinglife.model;

import java.util.Properties;

public class DBInfoModel {
	private String driver;
	private String url;
	private String userName;
	private String password;
	private String dataName;

	public DBInfoModel()
	{
	};

	public DBInfoModel(Properties prop)
	{
		this.driver = prop.getProperty("driver");
		this.dataName = prop.getProperty("dataName");
		this.password = prop.getProperty("pwd");
		this.userName = prop.getProperty("user");
		this.url = prop.getProperty("url");
	}

	public String getDriver()
	{
		return driver;
	}

	public void setDriver(String driver)
	{
		this.driver = driver;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDataName()
	{
		return dataName;
	}

	public void setDataName(String dataName)
	{
		this.dataName = dataName;
	}

}
