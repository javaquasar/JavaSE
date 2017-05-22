package com.javaquasar.java.core.chapter_11_String.example;

import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class UsingSplit {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		String[] words = sentence.split("\\s");
		for (String word : words)
			System.out.println(word);
	}

}
