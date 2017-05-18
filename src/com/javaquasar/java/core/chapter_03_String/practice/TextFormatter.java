package com.javaquasar.java.core.chapter_03_String.practice;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TextFormatter {
	static boolean isUpper(String word) {
		for (char ch : word.toCharArray()) {
			if (Character.isLowerCase(ch)) {
				return false;
			}
		}
		return true;
	}

	static String format(String line) {
		String[] wordArray = line.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (String word : wordArray) {
			if (!isUpper(word)) {
				word = word.toLowerCase();
			}
			sb.append(word);
			sb.append(" ");
		}
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0))); // эта строчка мне
																// не нравится
		return sb.toString().trim();
	}

	public static void main(String[] args) {

		System.out.println(format("МаМа МЫЛА РамУ."));
		System.out.println(format("мЫлА раМУ МАМА."));
		System.out.println(format("РАМА мыла МАму!"));
		System.out.println(format("РАМА мыла Мaму!"));

	}
}
