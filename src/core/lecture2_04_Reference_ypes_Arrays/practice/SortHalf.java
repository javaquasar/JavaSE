package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Arrays;
import java.util.Random;

public class SortHalf {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(10);
		System.out.println(Arrays.toString(array));
		bubblesort(array, 4);
		System.out.println(Arrays.toString(array));
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void bubblesort(int[] arr, int border) {
		for (int i = border - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
		
		for (int i = arr.length-1; i > arr.length-border; i--) {
			for (int j = arr.length-border; j < i; j++) {
				if (arr[j] < arr[j + 1])
					swap(arr, j, j + 1);
			}
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
