package com.javaquasar.java.core.chapter_23_Regular_Expressions.find_substring;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */


/*Нахождение всех подстрок, удовлетворяющих определенным требованиям*

Ввести строку, найти и вывести на экран, вывести все подстроки, 
которые соответствуют шаблону.*/

public class FindingAllSubstrings {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("text");
		Matcher matcher = pattern.matcher("textual texts texture tex");
		while (matcher.find()) {
			System.out.printf("Найден текст" + " \"%s\", начиная с позиции" + "%d и заканчивая позицией %d.%n", matcher.group(), matcher.start(), matcher.end());
		}

		Pattern pattern2 = Pattern.compile("\\+?text?");
		Matcher matcher2 = pattern2.matcher("textual texts texture tex");
		while (matcher2.find()) {
			System.out.printf("\"%s\"", matcher2.group());
		}

		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		String[] words = sentence.split("\\s");
		Pattern pattern3 = Pattern.compile("text");
		Matcher matcher3;
		for (String word : words) {
			matcher3 = pattern3.matcher(word);
			if (matcher3.find()) {
				System.out.println(word);
			}
		}
	}

}
