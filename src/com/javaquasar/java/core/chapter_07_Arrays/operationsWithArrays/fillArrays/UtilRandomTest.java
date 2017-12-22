package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.fillArrays;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class UtilRandomTest {

	public static void main(String[] args) {
		int[] a = new int[15];
		Random rand = new Random(100);
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(10); // случайные значения от 0 до 10
		}
		System.out.println(Arrays.toString(a));
	}

}
