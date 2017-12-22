package com.javaquasar.java.core.chapter_13_Collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BracketsWithoutExceptions {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Deque<Character> brackets = new ArrayDeque<>();
		String s = new Scanner(System.in).nextLine();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				brackets.push('(');
			if (s.charAt(i) == ')') {
				if (brackets.poll() == null) {
					System.out.println("Строка некорректна: лишние закрывающиеся скобки");
					return;
				}
			}
		}
		if (!brackets.isEmpty())
			System.out.println("Строка некорректна: не все скобки закрыты");
		else
			System.out.println("Строка корректна");
	}

}
