package com.swinglife.generator.factory;

import java.util.List;

import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.model.DBInfoModel;
import com.swinglife.model.ModelField;
import com.swinglife.utils.FreemarkerUtils;
import com.swinglife.utils.TableUtils;

/****
 * 生成单个model文件
 * 
 * @author Swinglife
 *
 */
public class SingleModelGeneratorFactory extends ModelGeneratorFactory {

	private SingleModelGeneratorFactory() {

	}

	public SingleModelGeneratorFactory(GeneratorConfigure gc) {
		super(gc);
		generatorConfigure = gc;
	}

	@Override
	public void generator() throws Exception {
		DBInfoModel dbInfo = initDatabase(generatorConfigure.getUsername(), generatorConfigure.getPassword(), generatorConfigure.getUrl(), generatorConfigure.getDataName(), generatorConfigure.getDriver());
		this.tableUtils = new TableUtils(dbInfo);
		List<ModelField> list = getModelFields(generatorConfigure.getTableName());
		FreemarkerUtils.createModelFile(generatorConfigure.getTableName(), TableUtils.getModelName(generatorConfigure.getTableName()), list, generatorConfigure);
	}

}
