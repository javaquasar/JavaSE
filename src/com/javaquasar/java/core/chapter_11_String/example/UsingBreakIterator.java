package com.javaquasar.java.core.chapter_11_String.example;

import java.text.BreakIterator;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class UsingBreakIterator {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		BreakIterator boundary = BreakIterator.getWordInstance();
		boundary.setText(sentence);
		int start = boundary.first();
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
			System.out.println(sentence.substring(start, end));
		}
	}

}