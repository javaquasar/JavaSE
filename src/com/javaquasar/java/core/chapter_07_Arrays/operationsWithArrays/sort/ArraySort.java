package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sort;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArraySort {

	public static void main(String[] args) {
		int[] a = new int[] { 11, 2, 10, 1 };
		Arrays.sort(a); // 1 2 10 11
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}