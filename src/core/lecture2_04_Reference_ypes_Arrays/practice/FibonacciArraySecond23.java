package core.lecture2_04_Reference_ypes_Arrays.practice;

import java.util.Arrays;

public class FibonacciArraySecond23 {

	private static long[] array = new long[92];
	private static int fibNumber = 1;

	static {
		array[0] = 0;
		array[1] = 1;
	}

	public static void main(String[] args) {
		// System.out.println(array.length);
		System.out.println(getFibNumber(1));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(2));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(5));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(3));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(15));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(6));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(7));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(93));
		System.out.println(Arrays.toString(array));
		System.out.println(getFibNumber(92));
		System.out.println(Arrays.toString(array));
		// print(array);

	}

	public static void print(long[] arr) {
		for (long number : arr) {
			if (number != 0) {
				System.out.print(" " + number);
			}
		}
		System.out.println();
	}

	private static String getFibNumber(int index) {
		if (index < 93) {
			if (index > fibNumber + 1) {
				int temp = fibNumber;
				for (int i = temp + 1; i < index; i++) {
					array[i] = array[i - 1] + array[i - 2];
					fibNumber++;
				}
				return "Element №" + index + " = " + array[index - 1];
			} else if (index <= fibNumber + 1) {
				return "Element №" + index + " = " + array[index - 1];
			}
		}
		return null;
	}
}
