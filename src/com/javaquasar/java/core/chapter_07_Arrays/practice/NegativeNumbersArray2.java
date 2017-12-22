package com.javaquasar.java.core.chapter_07_Arrays.practice;

import java.util.ArrayList;
import java.util.Random;

public class NegativeNumbersArray2 {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(100);
		getNegativeArray(array);
		// System.out.println(Arrays.toString(a));
	}

	public static ArrayList<Integer> getNegativeArray(int[] numbers) {

		ArrayList<Integer> array = new ArrayList<Integer>();
		int quantityNegativeNumbers = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0) {
				array.add(numbers[i]);
				quantityNegativeNumbers++;
			}
		}
		
		System.out.println("Количество отрицательных элементов " + quantityNegativeNumbers);
		System.out.println(array);

		return array;
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
