package com.swinglife.generator.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.support.ModelGeneratorSupportFactory;
import com.swinglife.model.DBInfoModel;
import com.swinglife.model.ModelField;
import com.swinglife.utils.FreemarkerUtils;
import com.swinglife.utils.TableUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ModelGeneratorFactory extends ModelGeneratorSupportFactory {

	// 配置文件
	protected GeneratorConfigure generatorConfigure = null;

	public ModelGeneratorFactory() {

	}

	@Deprecated
	public ModelGeneratorFactory(String username, String password, String url, String dataName, String driver) {
		generatorConfigure = new GeneratorConfigure();
		generatorConfigure.setDataName(dataName);
		generatorConfigure.setDriver(driver);
		generatorConfigure.setPassword(password);
		generatorConfigure.setUrl(url);
	}

	public ModelGeneratorFactory(GeneratorConfigure gc) {
		super(gc);
		generatorConfigure = gc;
	}

	@Override
	public void setGeneratorConfigure(GeneratorConfigure gc) {
		generatorConfigure = gc;
	}
	
	@Override
	public void generator() throws Exception {
		DBInfoModel dbInfo = initDatabase(generatorConfigure.getUsername(), generatorConfigure.getPassword(), generatorConfigure.getUrl(), generatorConfigure.getDataName(), generatorConfigure.getDriver());
		tableUtils = new TableUtils(dbInfo);
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			List<ModelField> modelFields = getModelFields(tableName);
			FreemarkerUtils.createModelFile(tableName, TableUtils.getModelName(tableName), modelFields,generatorConfigure);
		}
	}


}
