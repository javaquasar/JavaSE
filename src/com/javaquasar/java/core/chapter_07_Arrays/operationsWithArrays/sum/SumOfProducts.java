package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sum;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SumOfProducts {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 2, 3, 4 }, { 0, 1, 2 }, { 1, 1, 12 } };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int product = 1;
			for (int j = 0; j < a[i].length; j++) {
				product *= a[i][j];
			}
			sum += product;
		}
		System.out.println(sum);
	}

}
