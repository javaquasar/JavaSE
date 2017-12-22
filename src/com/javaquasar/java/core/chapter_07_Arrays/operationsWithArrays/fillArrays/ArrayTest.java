package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.fillArrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ArrayTest {
	public static void main(String[] args) {
		System.out.println("Введите количество элементов массива:");
		java.util.Scanner s = new java.util.Scanner(System.in);
		int size = s.nextInt();
		double[] a = new double[size];
		System.out.println("Введите элементы массива:");
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextDouble();
			// Работа с массивом
			// ...
		}
	}

}
