package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SwapElements {

	static void swap(int[] a) {
		int z = a[0];
		a[0] = a[1];
		a[1] = z;
	}

	public static void main(String[] args) {
		int[] b = { 1, 2 };
		swap(b);
		System.out.println(b[0]); // 2
		System.out.println(b[1]); // 1
	}

}
