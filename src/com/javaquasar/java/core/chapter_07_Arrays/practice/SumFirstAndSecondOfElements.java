package com.javaquasar.java.core.chapter_07_Arrays.practice;

import java.util.Random;

public class SumFirstAndSecondOfElements {
	public static void main(String[] args) {
		
		int[] array2 = { 1, 1, 1, 2, 2, 2, 2 };
		System.out.println(getTwoSums(array2, -5));
	}

	public static Boolean getTwoSums(int[] numbers, int k) {
		if ((k >= numbers.length) || (k <= 0)) {
			return null;
		}
		int sumFirst = 0;
		for (int i = 0; i < k; i++) {
			sumFirst += numbers[i];
		}
		int sumSecond = 0;
		for (int i = k; i < numbers.length; i++) {
			sumSecond += numbers[i];
		}
		System.out.println("Первая сумма = " + sumFirst);
		System.out.println("Вторая сумма = " + sumSecond);
		if (sumFirst > sumSecond) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] getRandomArrayNumber(int col) {
		int[] array = new int[col];
		Random rand = new Random(100);
		for (int i = 0; i < array.length; i++) {
			// случайные значения от -100 до 100
			array[i] = rand.nextInt(200) - 100;
		}
		return array;
	}

}
