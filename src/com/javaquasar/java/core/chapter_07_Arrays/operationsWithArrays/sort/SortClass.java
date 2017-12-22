package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.sort;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SortClass {

	public static void main(String[] args) {
		double[] a = { 11, 2.5, 4, 3, 5 };
		boolean mustSort;// Повторяем до тех пор,
							// пока mustSort равно true
		do {
			mustSort = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					// Меняем элементы местами:
					double temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					mustSort = true;
				}
			}
		} while (mustSort);
		System.out.println(Arrays.toString(a));
	}

}
