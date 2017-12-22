package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class CopyOfTest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = Arrays.copyOf(a, 3);
		System.out.println(Arrays.toString(b));// [1, 2, 3]
		int[] c = Arrays.copyOf(a, 6);
		System.out.println(Arrays.toString(c));// [1, 2, 3, 4, 0, 0]
		int[] d = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.toString(d));// [2, 3]
	}

}