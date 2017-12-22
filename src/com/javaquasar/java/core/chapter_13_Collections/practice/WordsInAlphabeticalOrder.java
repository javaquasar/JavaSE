package com.javaquasar.java.core.chapter_13_Collections.practice;

import java.util.Scanner;
import java.util.TreeSet;

/*6.1 Слова в алфавитном порядке*

Ввести предложение и вывести все различные слова предложения в алфавитном порядке. 
Использовать множество.*/

public class WordsInAlphabeticalOrder {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.print("Введите строку из слов -> ");
		scanner = new Scanner(System.in);
		String part = scanner.nextLine();
		System.out.println(getSortedList(part));
	}
	
	public static String getSortedList(String s) {
		TreeSet<String> ts = new TreeSet<String>();
		String[] words = s.split("\\s+");
		for (String word : words) {
			ts.add(word);
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (String word : ts) {
			stringBuilder.append(word);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
