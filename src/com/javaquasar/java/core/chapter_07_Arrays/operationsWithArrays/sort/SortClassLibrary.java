package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sort;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SortClassLibrary {
	public static void main(String[] args) {
		double[] a = { 11, 2.5, 4, 3, 5 };
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
