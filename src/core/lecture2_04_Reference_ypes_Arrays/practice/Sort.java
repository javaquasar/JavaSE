package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Arrays;
import java.util.Random;

public class Sort {

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
		int min, temp;
		 
	    for (int index = 0; index < arr.length-1; index++){
	        min = index;
	        for (int scan = index+1; scan < arr.length; scan++)
	            if (arr[scan] < arr[min])
	                min = scan;
	 
	        // Swap the values
	        temp = arr[min];
	        arr[min] = arr[index];
	        arr[index] = temp;
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
