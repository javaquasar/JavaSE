package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ReplaceZeros {

	public static void main(String[] args) {
		double[][] a = { { 1, -2, 3 }, { 2.1, 3, -4 }, { 0, -0.5, 11 } };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < 0) {
					a[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print("\t" + a[i][j]);
			}
			System.out.println();
		}
	}

}
