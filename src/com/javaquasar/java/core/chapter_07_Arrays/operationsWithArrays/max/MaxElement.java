package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.max;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class MaxElement {

	public static void main(String[] args) {
		int[] a = { 1, 2, 14, 8 };
		int indexOfMax = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[indexOfMax]) {
				indexOfMax = i;
			}
		}
		System.out.println(indexOfMax + " " + a[indexOfMax]);
	}

}
