package com.javaquasar.java.core.chapter_04_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
//Left shifting as a quick way to multiply by 2.
class MultByTwo {
	public static void main(String args[]) {
		int i;
		int num = 0xFFFFFFE;
		for (i = 0; i < 4; i++) {
			num = num << 1;
			System.out.println(num);
		}
	}
}