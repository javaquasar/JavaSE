package com.javaquasar.java.core.chapter_13_Collections.example.deque;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new PriorityQueue<>();
		queue.add("First");
		queue.add("Second");
		queue.add("Third");
		queue.add("Fourth");
		String s;
		while ((s = queue.poll()) != null)
			System.out.print(s + " "); // First Fourth Second Third
	}

}
