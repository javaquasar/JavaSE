package com.javaquasar.java.core.chapter_23_Regular_Expressions;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class RegexTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("%nВведите регулярное выражение: ");
		String ex = scan.nextLine();
		Pattern pattern = Pattern.compile(ex);
		System.out.printf("Введите строку для поиска: ");
		Matcher matcher = pattern.matcher(scan.nextLine());
		if (matcher.find()) {
			System.out.printf("Найден текст" + " \"%s\", начиная с позиции" + "%d и заканчивая позицией %d.%n", matcher.group(), matcher.start(), matcher.end());
		}
	}

}
