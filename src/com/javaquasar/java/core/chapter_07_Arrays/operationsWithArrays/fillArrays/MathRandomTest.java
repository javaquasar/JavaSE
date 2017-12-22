package com.javaquasar.java.core.chapter_07_Arrays.operationsWithArrays.fillArrays;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class MathRandomTest {

	public static void main(String[] args) {
		double[] a = new double[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.random() * 10; // случайные значения от 0 до 10
		}
		System.out.println(Arrays.toString(a));
	}

}
