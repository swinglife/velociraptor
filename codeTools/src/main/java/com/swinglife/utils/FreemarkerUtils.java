package com.swinglife.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swinglife.generator.configure.GeneratorConfigure;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtils {

	/***
	 * 创建生成后的文件
	 * 
	 * @param modelName
	 * @param list
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createControllerFile(String modelName, GeneratorConfigure generatorConfigure) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(generatorConfigure.getTemplatePath()));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template temp = cfg.getTemplate("controller.ftl");
		Writer out = null;
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("modelName", modelName);
		String index = modelName.substring(0, 1).toLowerCase();
		String path = index + modelName.substring(1, modelName.length());
		root.put("path", path);
		out = new OutputStreamWriter(new FileOutputStream(new File(generatorConfigure.getBuildPath() + modelName + "Controller.java")), "UTF-8");
		temp.process(root, out);
		out.flush();
	}

	/***
	 * 创建生成后的文件
	 * 
	 * @param modelName
	 * @param list
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createModelFile(String tableName, String modelName, List list, GeneratorConfigure generatorConfigure) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(generatorConfigure.getTemplatePath()));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template temp = cfg.getTemplate("model.ftl");
		Writer out = null;
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("list", list);
		root.put("tableName", tableName);
		root.put("modelName", modelName);
		out = new OutputStreamWriter(new FileOutputStream(new File(generatorConfigure.getBuildPath() + modelName + ".java")), "UTF-8");
		temp.process(root, out);
		out.flush();
	}
}
