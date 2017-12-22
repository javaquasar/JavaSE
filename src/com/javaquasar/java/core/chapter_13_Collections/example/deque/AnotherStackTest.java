package com.javaquasar.java.core.chapter_13_Collections.example.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnotherStackTest {

	public static void main(String[] args) {
		Deque<String> stack = new ArrayDeque<>();
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		stack.push("Fourth");
		String s;
		while (!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(s + " "); // Fourth Third Second First
		}
	}

}
