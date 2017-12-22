package com.javaquasar.java.core.chapter_07_Arrays.practice;

import java.util.Arrays;
import java.util.Random;

public class BackOrder {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(10);
		System.out.println(Arrays.toString(array));
		reverse(array);
		System.out.println(Arrays.toString(array));
	}

	public static void reverse(int[] numbers) {
		int temp = 0;
		int length = numbers.length;
		for (int i = 0; i < length / 2; i++) {
			temp = numbers[length - 1 - i];
			numbers[length - 1 - i] = numbers[i];
			numbers[i] = temp;
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
