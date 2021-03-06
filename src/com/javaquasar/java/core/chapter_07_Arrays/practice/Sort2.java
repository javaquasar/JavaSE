package com.javaquasar.java.core.chapter_07_Arrays.practice;

import java.util.Arrays;
import java.util.Random;

public class Sort2 {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(10);
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));
		insertionSort(array);
		System.out.println(Arrays.toString(array));

	}
	
	public static void selectionSort(int[] arr) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int min_i = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					min_i = j;
				}
			}
			if (i != min_i) {
				int tmp = arr[i];
				arr[i] = arr[min_i];
				arr[min_i] = tmp;
			}
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Сортировка выбором длилась " + timeSpent + "мс");
	}
	
	public static void insertionSort(int[] arr) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < arr.length; i++) {
			int currElem = arr[i];
			int prevKey = i - 1;
			while (prevKey >= 0 && arr[prevKey] > currElem) {
				arr[prevKey + 1] = arr[prevKey];
				arr[prevKey] = currElem;
				prevKey--;

			}
		}
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("Сортировка вставками длилась " + timeSpent + "мс");
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
