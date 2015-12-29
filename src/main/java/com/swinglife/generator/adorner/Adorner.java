package com.swinglife.generator.adorner;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.support.ModelGeneratorSupportFactory;

public abstract class Adorner implements GeneratorAdorner {

	protected GeneratorFactory generatorFactory = null;
	protected GeneratorConfigure generatorConfigure = null;

	
	@Override
	public void initAdornet(GeneratorFactory generatorFactory) {
		this.generatorFactory = generatorFactory;
	}

	@Override
	public void build() throws Exception {
		generatorFactory.generator();
	}


}
