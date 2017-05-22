package com.javaquasar.java.core.chapter_23_Regular_Expressions;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class RegexPhoneValidation {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("%nВведите номер телефона: ");
		String phone = scanner.nextLine();
		Pattern p = Pattern.compile("\\+?(380-)?((57-)?\\d{3}|(572-)?\\d{2})-\\d{2}-\\d{2}$");
		Matcher m = p.matcher(phone);
		if (m.matches()) {
			System.out.println("\"" + phone + "\" - правильный формат номера");
		} else {
			System.out.println("\"" + phone + "\" - неправильный формат номера");
		}
	}

}
