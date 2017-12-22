package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.fillArrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FillArray {

	public static void main(String[] args) {
		int[] a = new int[6];
		java.util.Arrays.fill(a, 0, 4, 12); // Другие элементы равны 0
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		java.util.Arrays.fill(a, 100); // Все элементы равны 100
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
