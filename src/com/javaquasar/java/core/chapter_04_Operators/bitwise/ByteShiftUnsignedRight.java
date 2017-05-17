package com.javaquasar.java.core.chapter_04_Operators.bitwise;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ByteShiftUnsignedRight {
	public static void main(String args[]) {
		int a = -1;
		a = a >>> 24;
		// Here is the same operation in binary form to further illustrate what is happening:
		// 11111111 11111111 11111111 11111111 –1 in binary as an int
		// >>>24
		// 00000000 00000000 00000000 11111111 255 in binary as an int
		System.out.println(a);
	}
}
