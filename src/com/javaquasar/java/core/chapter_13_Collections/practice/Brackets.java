package com.javaquasar.java.core.chapter_13_Collections.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/*6.4 Проверка корректности скобок с учетом кавычек*

Дополнить пример 6.3 проверкой, не находятся ли скобки в кавычках. 
В этом случае они должны игнорироваться.*/

public class Brackets {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Deque<Character> brackets = new ArrayDeque<>();
			String s = "\"(\"(())()\"(\"\")\""; // new
												// Scanner(System.in).nextLine();
			System.out.println(s);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					if ((i == 0) || (i == (s.length() - 1))) {
						brackets.push('(');
						System.out.println(i + "первый " + s.charAt(i));
					} else {
						if ((s.charAt(i - 1) != '"') || (s.charAt(i + 1) != '"')) {
							brackets.push('(');
						}
					}
				if (s.charAt(i) == ')') {
					if ((i == 0) || (i == (s.length() - 1))) {
						brackets.pop();
						System.out.println(i + "первый " + s.charAt(i));
					} else {
						if ((s.charAt(i - 1) != '"') || (s.charAt(i + 1) != '"')) {
							brackets.pop();
						}
					}
				}
			}
			if (!brackets.isEmpty())
				throw new Exception();
			System.out.println("Строка корректна");
		} catch (Exception e) {
			System.out.println("Строка некорректна");
		}
	}

}
