package com.javaquasar.java.core.chapter_11_String.example;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class UsingStringTokenizer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(sentence);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}