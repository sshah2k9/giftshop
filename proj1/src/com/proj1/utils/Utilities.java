package com.proj1.utils;

public class Utilities {
	private static String OS = System.getProperty("os.name");
	public static boolean isWindows(){
		return OS.startsWith("Windows");
	}
}
