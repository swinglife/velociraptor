package com.swinglife.utils;

import com.swinglife.model.DBInfoModel;

public class DatabaseUtils {

	/****
	 * 创建 createDBInfo
	 * 
	 * @param dataName
	 * @param driver
	 * @param password
	 * @param username
	 * @param url
	 * @return
	 */
	public static DBInfoModel createDBInfo(String username, String password, String url, String dataName, String driver) {
		DBInfoModel dbInfoModel = new DBInfoModel();
		dbInfoModel.setDataName(dataName);
		dbInfoModel.setDriver(driver);
		dbInfoModel.setPassword(password);
		dbInfoModel.setUrl(url);
		dbInfoModel.setUserName(username);
		return dbInfoModel;
	}
}
