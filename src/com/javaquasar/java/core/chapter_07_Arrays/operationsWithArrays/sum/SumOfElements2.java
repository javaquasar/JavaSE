package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sum;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SumOfElements2 {
	public static void main(String[] args) {
		double a[] = { 1, 2, 1, 2.5, 1 };
		double sum = 0;
		for (double x : a) {
			sum += x;
		}
		System.out.println("Sum is " + sum);
	}
}
