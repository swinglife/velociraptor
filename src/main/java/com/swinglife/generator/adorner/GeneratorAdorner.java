package com.swinglife.generator.adorner;

import com.swinglife.generator.GeneratorFactory;
import com.swinglife.generator.configure.GeneratorConfigure;
import com.swinglife.generator.support.ModelGeneratorSupportFactory;

/***
 * 生成器装饰器
 * 
 * @author Swinglife
 *
 */
public interface GeneratorAdorner {

	/***
	 * 初始化装饰器 用于装饰生成器工厂方法
	 * 
	 * @param generatorFactory
	 *            生成器工厂
	 */
	void initAdornet(GeneratorFactory generatorFactory);

	/***
	 * 创建模板
	 */
	void build() throws Exception;

	/***
	 * 设置配置文件类
	 * @param generatorConfigure
	 */
	void setGeneratorConfigure(GeneratorConfigure generatorConfigure);

}
