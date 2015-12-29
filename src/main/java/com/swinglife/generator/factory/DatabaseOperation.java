package com.swinglife.generator.factory;

import java.sql.SQLException;
import java.util.List;

import com.swinglife.database.support.DatabaseSupport;
import com.swinglife.generator.configure.DatabaseConfigure;
import com.swinglife.model.DBInfoModel;
import com.swinglife.model.ModelField;
import com.swinglife.utils.DatabaseUtils;
import com.swinglife.utils.TableUtils;

public class DatabaseOperation implements DatabaseSupport {

	// table帮助类
	protected TableUtils tableUtils = null;

	protected DatabaseConfigure dc = null;

	public DatabaseOperation() {

	}

	@Override
	public void setDatabaseConfigure(DatabaseConfigure dc) {
		this.dc = dc;
	}

	public DatabaseOperation(DatabaseConfigure dc) {
		DBInfoModel dbInfoModel = initDatabase(dc.getUsername(), dc.getPassword(), dc.getUrl(), dc.getDataName(), dc.getDriver());
		tableUtils = new TableUtils(dbInfoModel);
	}

	@Override
	public DBInfoModel initDatabase(String username, String password, String url, String dataName, String driver) {
		return DatabaseUtils.createDBInfo(username, password, url, dataName, driver);
	}

	@Override
	public List<String> getTableNames() throws SQLException {
		return tableUtils.getTableName();
	}

	@Override
	public List<ModelField> getModelFields(String tableName) throws Exception {
		return tableUtils.getTableModel(tableName);
	}

}
