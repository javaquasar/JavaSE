package com.javaquasar.java.core.chapter_13_Collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Brackets {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Deque<Character> brackets = new ArrayDeque<>();
			String s = new Scanner(System.in).nextLine();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					brackets.push('(');
				if (s.charAt(i) == ')')
					brackets.pop();
			}
			if (!brackets.isEmpty())
				throw new Exception();
			System.out.println("Строка корректна");
		} catch (Exception e) {
			System.out.println("Строка некорректна");
		}
	}

}
