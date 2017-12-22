package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Arrays;
import java.util.Random;

public class NegativeNumbersArray {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(100);
		System.out.println(Arrays.toString(getNegativeArray(array)));
	}

	public static int[] getNegativeArray(int[] numbers) {
		int quantity = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0) {
				quantity++;
			}
		}
		int[] arr = new int[quantity];
		quantity = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0) {
				arr[quantity] = (numbers[i]);
				quantity++;
			}
		}
		System.out.println("Количество отрицательных элементов " + quantity);
		return arr;
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
