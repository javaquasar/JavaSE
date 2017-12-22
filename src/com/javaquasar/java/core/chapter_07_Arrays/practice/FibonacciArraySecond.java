package com.javaquasar.java.core.chapter_07_Arrays.practice;

public class FibonacciArraySecond {

	public static void main(String[] args) {

		int[] array = new int[300];
		fillArrayFib(array, 10);
		print(array);
		fillArrayFib(array, 10);
		print(array);
	}

	public static void print(int[] arr) {
		for (int number : arr) {
			if (number != 0) {
				System.out.print(" " + number);
			}
		}
		System.out.println();
	}

	public static void fillArrayFib(int[] arr, int quantity) {
		if ((arr[0] == 0) || (arr[1] == 0)) {
			arr[0] = 1;
			arr[1] = 1;
			fill(arr, quantity-3);
		} else {
			fill(arr, quantity-1);
		}
	}

	public static void fill(int[] arr, int quantity) {
		int border = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] == 0) && (border <= quantity)) {
				border++;
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}
	}
}
