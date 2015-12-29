package com.swinglife.database.support;

import java.sql.SQLException;
import java.util.List;

import com.swinglife.generator.configure.DatabaseConfigure;
import com.swinglife.model.DBInfoModel;
import com.swinglife.model.ModelField;

public interface DatabaseSupport {

	public void setDatabaseConfigure(DatabaseConfigure dc);

	public DBInfoModel initDatabase(String username, String password, String url, String dataName, String driver);

	public List<String> getTableNames() throws SQLException;

	public List<ModelField> getModelFields(String tableName) throws Exception;

}
