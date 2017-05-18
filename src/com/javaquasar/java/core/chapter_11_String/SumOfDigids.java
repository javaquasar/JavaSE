package com.javaquasar.java.core.chapter_11_String;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SumOfDigids {
	public static void main(String[] args) {
		String n = args[0];
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += Integer.parseInt(n.charAt(i) + "");
		}
		System.out.println(sum);
	}
}
