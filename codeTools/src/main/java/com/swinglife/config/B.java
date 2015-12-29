package com.swinglife.config;

public class B extends Super{

	@Override
	public void init() {
		System.out.println("B init");
	}

	@Override
	public void service() {
		System.out.println("B service");
	}

	@Override
	public void close() {
		System.out.println("B close");
	}

}
