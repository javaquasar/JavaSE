package com.javaquasar.java.core.chapter_11_String;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SortWords {

	@SuppressWarnings("resource")
	// Сортировка слов в предложении по алфавиту
	public static void main(String[] args) {
		String s = new Scanner(System.in).nextLine();
		StringTokenizer st = new StringTokenizer(s);
		int count = 0;
		while (st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		String[] words = new String[count];
		st = new StringTokenizer(s);
		for (int i = 0; i < words.length; i++) {
			words[i] = st.nextToken();
		}
		Arrays.sort(words);
		String result = "";
		for (String word : words) {
			result += word + " ";
		}
		System.out.println(result);
	}

}
