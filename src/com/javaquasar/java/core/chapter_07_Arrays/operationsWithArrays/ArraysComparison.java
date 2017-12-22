package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArraysComparison {

	public static void main(String[] args) {
		double[] a = null, b = null;
		System.out.println(Arrays.equals(a, b)); // true
		a = new double[] { 1, 2, 3, 4 };
		b = new double[4];
		System.out.println(Arrays.equals(a, b)); // false
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println(Arrays.equals(a, b)); // true
		b[3] = 4.5;
		System.out.println(Arrays.equals(a, b)); // false
	}

}
