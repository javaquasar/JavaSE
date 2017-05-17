package com.javaquasar.java.core.chapter_04_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
class OpBitEquals {
	public static void main(String args[]) {
		int a = 1;
		int b = 2;
		int c = 3;
		a |= 4;
		b >>= 1;
		c <<= 1;
		a ^= c;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
