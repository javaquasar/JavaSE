package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sum;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SumWithRecursion {
	static double sum(double[] a, int n) {
		if (n <= 0)
			return 0;
		n--;
		return a[n] + sum(a, n);
	}

	static double sum(double[] a) {
		return sum(a, a.length);
	}

	public static void main(String[] args) {
		double[] a = { 1, 2, 1, 2.5, 1 };
		System.out.println("Sum is " + sum(a));
	}
}
