package com.swinglife.config;

public abstract class Super {

	public abstract void init();

	public abstract void service();

	public abstract void close();

	public void exc() {
		init();
		service();
		close();
	}
}
