package com.swinglife.generator.support;

import com.swinglife.generator.GeneratorFactory;

public abstract class MVCGeneratorFactorySupport implements GeneratorFactory {

	/** 是否生成add方法 **/
	public boolean GeneratorAddMethod = true;
	/** 是否生成delete方法 **/
	public boolean GeneratorDeleteMethod = true;
	/**是否生成edit方法**/
	public boolean GeneratorEditMethod = true;
	/**是否生成list方法**/
	public boolean GeneratorListMethod = true;
	/**是否生成toAdd方法**/
	public boolean GeneratorToAddMethod = true;
	/**是否生成info方法**/
	public boolean GeneratorInfoMethod = true;

	
}
