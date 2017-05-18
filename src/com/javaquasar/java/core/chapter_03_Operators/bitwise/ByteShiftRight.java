package com.javaquasar.java.core.chapter_03_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ByteShiftRight {
	public static void main(String args[]) {
		int a = 32;
		a = a >> 2; // a now contains 8
		System.out.println(a);
		int b = 35;
		b = b >> 2; // a contains 8
		// Looking at the same operation in binary 
		// shows more clearly how this happens:
		// 00100011 35
		// >> 2
		// 00001000 8
		System.out.println(b);
	}
}
