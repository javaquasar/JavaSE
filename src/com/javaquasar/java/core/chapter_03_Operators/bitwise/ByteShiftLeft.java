package com.javaquasar.java.core.chapter_03_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ByteShiftLeft {
	public static void main(String args[]) {
		byte a = 64, b;
		int i;
		i = a << 2;
		b = (byte) (a << 2);
		System.out.println("Original value of a: " + a);
		System.out.println("i and b: " + i + " " + b);
	}
}