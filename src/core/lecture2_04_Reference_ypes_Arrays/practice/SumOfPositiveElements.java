package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Random;

public class SumOfPositiveElements {

	public static void main(String[] args) {
		int[] array = getRandomArrayNumber(100);
		// int[] array = { 1, 2, -2, 3, -8, -9, 1 };
		System.out.println("Сумма положительных чисел = "
				+ sumPositiveNumber(array));
		System.out.println("Сумма положительных чисел рекурсивно= "
				+ sumPositiveNumbeRecursion(array, 0));
	}

	public static int sumPositiveNumber(int[] numbers) {
		int temp = 0;
		for (int number : numbers) {
			if (number > 0) {
				temp += number;
			}
		}
		return temp;
	}

	public static int sumPositiveNumbeRecursion(int[] numbers, int n) {
		int temp = 0;
		if ((n < numbers.length) && (numbers[n] > 0)) {
			return numbers[n] + sumPositiveNumbeRecursion(numbers, n + 1);
		} else if (n < numbers.length) {
			return sumPositiveNumbeRecursion(numbers, n + 1);
		}
		return temp;
	}

	public static int sumPositiveNumbeRecursionBad(int[] numbers, int n) {
		int temp = 0;
		int i = n;
		if ((numbers.length != 0) && (n < numbers.length)) {
			for (; i < numbers.length; i++) {
				if (numbers[i] > 0) {
					return numbers[i]
							+ sumPositiveNumbeRecursion(numbers, i + 1);
				}
			}
		}
		return temp;
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
