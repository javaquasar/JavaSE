package com.javaquasar.java.core.chapter_11_String.practice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class NeWo {

	private static int Error = 0;

	// Чтение
	public static String ReadLine() {
		try {
			return new BufferedReader(new InputStreamReader(System.in))
					.readLine();
		} catch (IOException e) {
			return new String();
		}
	}

	// Проверяет строку на корректность
	public static boolean isValid(String s) {
		String open = "([{<";
		String close = ")]}>";
		Stack stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < open.length(); j++) {
				if (s.charAt(i) == open.charAt(j)) {
					stack.push(open.charAt(j));
				}
			}
			for (int j = 0; j < close.length(); j++) {
				if (s.charAt(i) == close.charAt(j)) {
					if (!stack.isEmpty()) {
						if ((stack.peek() != (Object) '(')
								&& (stack.peek() == (Object) (char) ((int) close
										.charAt(j) - 2))) {
							stack.pop();
						} else if (stack.peek() == (Object) '('
								&& close.charAt(j) == ')') {
							stack.pop();
						} else {
							Error = i + 1;
							return false;
						}
					} else {
						Error = i + 1;
						return false;
					}
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else {
			Error = s.length();
			return false;
		}
	}

	// Если последний вызов isValid обнаружил ошибку, возвращает
	// позицию, в которой обнаружена ошибка
	public static int getErrorPos() {
		return Error;
	}

	// Если последний вызов isValid обнаружил ошибку, возвращает
	// сообщение об ошибке
	public static String getErrorMessage() {
		if (Error > 0)
			return "Error in " + getErrorPos() + " position";
		else
			return "Accepted";
	}

	public static void run() {
		String str = ReadLine();
		System.out
				.println(isValid("[ {([])} ]a - (b - (c - []a) / (b<> + c) - 2)"));
		System.out.println(getErrorMessage());
		isValid(str);
		System.out.println(getErrorMessage());
	}

	public static void main(String[] args) {
		run();
	}
}
