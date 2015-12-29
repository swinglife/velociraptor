package com.swinglife.generator.adorner;

import java.util.List;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.factory.DatabaseOperation;
import com.swinglife.utils.FreemarkerUtils;
import com.swinglife.utils.TableUtils;

public class MVCGeneratorAdorner extends Adorner {

	private MVCGeneratorAdorner() {
	};

	public MVCGeneratorAdorner(GeneratorFactory generatorFactory) {
		initAdornet(generatorFactory);
	}

	@Override
	public void build() throws Exception {
		generatorFactory.setGeneratorConfigure(generatorConfigure);
		super.build();
		DatabaseOperation dbo = new DatabaseOperation(generatorConfigure);
		List<String> list = dbo.getTableNames();
		for (String tableName : list) {
			FreemarkerUtils.createControllerFile(TableUtils.getModelName(tableName), generatorConfigure);
			System.out.println("生成:" + TableUtils.getModelName(tableName));
		}
	}

	@Override
	public void setGeneratorConfigure(GeneratorConfigure generatorConfigure) {
		super.generatorConfigure = generatorConfigure;
	}

}
