package com.javaquasar.java.core.chapter_20_Localization.example.sort;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SortDemo {

	public static void main(String[] args) {
		String[] words = { "воля", "воїн", "возити" };
		// Осуществляем сортировку по умолчанию:
		Arrays.sort(words);
		System.out.println(Arrays.asList(words)); // [возити, воля, воїн]
		// Осуществляем сортировку с учетом локализации:
		Arrays.sort(words, new Comparator<String>() {
			Collator collator = Collator.getInstance(new Locale("uk"));

			@Override
			public int compare(String s1, String s2) {
				return collator.compare(s1, s2);
			}
		});
		System.out.println(Arrays.asList(words)); // [возити, воїн, воля]
	}

}