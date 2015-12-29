package com.swinglife.generator;

import com.swinglife.generator.configure.GeneratorConfigure;

/***
 * 生成器工厂类
 * 
 * @author Swinglife
 *
 */
public interface GeneratorFactory {


	/***
	 * 生成方法
	 * 
	 * @throws Exception
	 */
	public void generator() throws Exception;

	
	public void setGeneratorConfigure(GeneratorConfigure generatorConfigure);


}
