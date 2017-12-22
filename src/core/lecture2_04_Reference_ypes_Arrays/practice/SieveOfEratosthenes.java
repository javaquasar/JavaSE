package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(100);
		System.out.println(Arrays.toString(array));
		sortEratosthenes(array);
		System.out.println(Arrays.toString(array));
		printEratosthen(array);				
	}
	
	public static void sortEratosthenes (int[] arr) {
		int border = (int) Math.sqrt(arr.length);
		for (int i = 2; i <= border; i++) {
			for (int j = i*i; j < arr.length; j++) {
				if (arr[j]%i == 0) {
					arr[j] = -1;
				}
			}			
		}
	}
	
	public static void printEratosthen(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static int[] getRandomArrayNumber(int col) {
		int[] array = new int[col];
		
		for (int i = 0; i < array.length; i++) {
			// случайные значения от -100 до 100
			array[i] = i+1;
		}
		return array;
	}

}
