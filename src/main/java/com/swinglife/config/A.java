package com.swinglife.config;

public class A extends Super {

	@Override
	public void init() {
		System.out.println("A init");
	}

	@Override
	public void service() {
		System.out.println("A service");
	}

	@Override
	public void close() {
		System.out.println("A close");
	}

	

}
