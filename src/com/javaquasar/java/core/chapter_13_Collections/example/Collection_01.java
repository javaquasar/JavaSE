package com.javaquasar.java.core.chapter_13_Collections.example;

import java.util.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Collection_01 {
	private static Scanner scanner;
	private static String string;
	private static Collection<String> A;
	private static Collection<String> B;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Для тестирования ArraList -> 1");
		System.out.println("Для тестирования HashSet -> 2");
		System.out.println("Для тестирования TreeSet -> 3");
		string = scanner.nextLine();
		switch (string) {
		case "1":
			A = new ArrayList<>();
			B = new ArrayList<>();
			break;
		case "2":
			A = new HashSet<>();
			B = new HashSet<>();
			break;
		case "3":
			A = new TreeSet<>();
			B = new TreeSet<>();
			break;
		}

		A.add("a");
		A.add("b");
		A.add("c");

		B.add("b");
		B.add("c");
		B.add("d");
		
		// Теория множеств
		
		System.out.println("Объеденения множеств A∪B -> 1");
		System.out.println("Пересечения множеств A∩B -> 2");
		System.out.println("Разница множеств A\\B -> 3");
		string = scanner.nextLine();
		
		System.out.println("Множество A:");
		System.out.println(A);
		System.out.println("Множество B:");
		System.out.println(B);
		
		switch (string) {
		case "1":
			A.addAll(B);
			break;
		case "2":
			A.retainAll(B);
			break;
		case "3":
			A.removeAll(B);
			break;
		}

		System.out.println("Множество - результат операции:");
		System.out.println(A);
		
		HashMap<Integer, Integer> n;
		Object o;
		//Objects do;
		ArithmeticException k;
		LinkedHashMap h;
	}
}
