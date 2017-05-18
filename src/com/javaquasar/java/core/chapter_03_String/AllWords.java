package com.javaquasar.java.core.chapter_03_String;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class AllWords {

	@SuppressWarnings("resource")
	// Как разбить текст на слова
	public static void main(String[] args) {
		System.out.println("Введите предложение");
		String s = new Scanner(System.in).nextLine();
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}