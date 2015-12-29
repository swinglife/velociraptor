package com.swinglife.tools;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.adorner.Adorner;
import com.swinglife.generator.adorner.GeneratorAdorner;
import com.swinglife.generator.adorner.MVCGeneratorAdorner;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.factory.ModelGeneratorFactory;
import com.swinglife.generator.factory.SingleModelGeneratorFactory;
import com.swinglife.generator.support.ModelGeneratorSupportFactory;
import com.swinglife.model.DBInfoModel;
import com.swinglife.model.ModelField;
import com.swinglife.utils.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Swinglife on 15/11/16.
 */
public class Main {
	private final static String dataName = "daxidi";
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String password = "123456";
	private final static String username = "root";
	private final static String url = "jdbc:mysql://localhost:3306/daxidi?useUnicode=true&characterEncoding=utf-8";

	// 模板路径
	private final static String TEMPLATE_PATH = "./src/main/java/com/swinglife/template/";

	public static void main(String[] args) throws Exception {
		GeneratorConfigure gc = new GeneratorConfigure();
		gc.setDataName(dataName);
		gc.setDriver(driver);
		gc.setPassword(password);
		gc.setUrl(url);
		gc.setUsername(username);
		gc.setTableName("t_user");
		gc.setBuildPath("/Users/Swinglife/Desktop/code/");
		gc.setTemplatePath(TEMPLATE_PATH);
		// GeneratorFactory g = new ModelGeneratorFactory(gc); //new
		// ModelGeneratorFactory(username,password,url,dataName,driver);
		// g.generator();

		GeneratorFactory generator = new ModelGeneratorFactory();
		GeneratorAdorner adorner = new MVCGeneratorAdorner(generator);
		adorner.setGeneratorConfigure(gc);
		adorner.build();
	}
}
