package com.swinglife.utils;

public class Format {

	public static String toIndexUp(String str)
	{
		String index = str.substring(0, 1);
		String end = str.substring(1, str.length());
		String buffer = index.toUpperCase() + end;
		return buffer;
	}
}
