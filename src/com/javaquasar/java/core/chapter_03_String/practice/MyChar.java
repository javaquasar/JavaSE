package com.javaquasar.java.core.chapter_03_String.practice;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class MyChar {
	public static int letterToNumber(String letter) {
		int number = 0;
		for (int i = letter.length() - 1, j = 0; i >= 0; i--, j++) {
			int num = (int) (letter.charAt(i)) % 64;
			number += num * Math.pow(26, j);
		}
		return number;
	}

	public static String numberToLetter(int number) {

		String result = "";
		while (number > 0) {
			if (number % 26 != 0) {
				result = (char) (number % 26 + 64) + result;
			} else {
				result = "Z" + result;
				number--;
			}
			number /= 26;
		}
		return result;
	}

	public static String letterToNext(String letter) {
		String output = "";
		int count = letter.length() - 1;
		int lastLetter = (int) (letter.charAt(count) % 64);
		while (lastLetter == 26) {
			if (count == 0) {
				output = "A" + output;
				break;
			} else {
				output = "A" + output;
				count--;
				lastLetter = (int) (letter.charAt(count) % 64);
			}
		}
		if (count == 0) {
			output = (char) ((int) (letter.charAt(count)) - 25) + output;
		} else {
			output = (char) ((int) (letter.charAt(count)) + 1) + output;
			for (int i = count - 1; i >= 0; i--) {
				output = letter.charAt(i) + output;
			}
		}
		return output;
	}

	public static String letterToNext2(String letter) {
		String output = "";
		int size = letter.length();
		int count = 1;
		int asciilast;
		for (int i = size - 1; i >= 0; i--) {
			asciilast = (int) letter.charAt(i) + count;
			if (asciilast == 91) {
				output = "A" + output;
			} else {
				output = (char) asciilast + output;
				count = 0;
			}
		}
		if (count == 1) {
			output = "A" + output;
		}
		return output;

	}

	public static String test(String str) {
		int strLength = str.length();
		char[] input = str.toCharArray();
		char[] output = new char[strLength + 1];
		int remember = 1;
		for (int i = strLength - 1; i >= 0; i--) {
			int letterIndex = (int) (input[i]) + remember;
			if (letterIndex == 91) {
				letterIndex = 65;
			} else {
				remember = 0;
			}
			output[i + 1] = (char) letterIndex;
		}
		if (remember == 1) {
			output[0] = 'A';
		}
		return new String(output).trim();
	}

	public static void main(String[] args) {

		System.out.println(letterToNumber("AA"));
		System.out.println(numberToLetter(312));
		// System.out.println(letterToNext("ZHF"));
		// System.out.println(test("ZHF"));
		System.out.println(letterToNext2("AA"));

	}

}
