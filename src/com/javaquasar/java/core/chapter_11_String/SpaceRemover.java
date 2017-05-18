package com.javaquasar.java.core.chapter_11_String;

/**
 * Created by Java Quasar on 16.05.17.
 */

// удаление двойных пробелов из текста
public class SpaceRemover {
	public static void main(String[] args) {
		System.out.println(args[0]);
		String s = args[0];
		while (s.indexOf("  ") >= 0)
			s = s.replaceAll("  ", " ");
		System.out.println(s);
	}
}
