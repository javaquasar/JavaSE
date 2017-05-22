package com.javaquasar.java.core.chapter_11_String.example;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ReverseStringCharacterExample {
	private static final String text = "Jackdaws love my big sphinx of quartz";

	public static void main(String[] args) {
		CharacterIterator it = new StringCharacterIterator(text);
		for (char ch = it.last(); ch != CharacterIterator.DONE; ch = it.next()) {
			System.out.print(ch);
		}
	}

}
