package com.swinglife.generator.support;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.factory.DatabaseOperation;

public abstract class ModelGeneratorSupportFactory extends DatabaseOperation implements GeneratorFactory {

	public GeneratorConfigure generatorConfigure = null;

	
	public ModelGeneratorSupportFactory(GeneratorConfigure gc) {
		super(gc);
	}

	public ModelGeneratorSupportFactory() {
	};

}
