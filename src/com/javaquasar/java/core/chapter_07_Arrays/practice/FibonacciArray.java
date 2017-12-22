package com.javaquasar.java.core.chapter_07_Arrays.practice;

import java.util.ArrayList;

public class FibonacciArray {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<Integer>();
		//array.add(1);
		//array.add(1);
		fillArrayFib(array, 10);
		System.out.println(array);

	}

	public static void fillArrayFib(ArrayList<Integer> arr, int quantity) {
		int sizeArray = arr.size();
		int border = quantity;
		switch (sizeArray) {
		case 0:
			arr.add(1);
			border--;
		case 1:
			arr.add(1);
			border--;
		default:
			for (int i = 0; i < border; i++) {
				arr.add(arr.get(arr.size() - 1) + arr.get(arr.size() - 2));
			}
		}
	}
}
