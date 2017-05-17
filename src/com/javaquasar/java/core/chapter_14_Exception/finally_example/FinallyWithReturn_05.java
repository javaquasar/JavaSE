package com.javaquasar.java.core.chapter_14_Exception.finally_example;

/**
 * Created by Java Quasar on 16.05.17.
 */
/* Однако finally-секция может «перебить» throw/return при помощи другого throw/returnÎ*/

public class FinallyWithReturn_05 {
	public static void main(String[] args) {
		System.err.println(f());
	}

	@SuppressWarnings("finally")
	public static int f() {
		try {
			return 0;
		} finally {
			throw new RuntimeException();
		}
	}
}
