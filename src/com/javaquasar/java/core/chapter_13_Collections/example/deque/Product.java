package com.javaquasar.java.core.chapter_13_Collections.example.deque;

import java.util.*;

public class Product {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>(100, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return -Double.compare(i1, i2);
			}
		});
		Scanner scanner = new Scanner(System.in);
		Integer k;
		do {
			k = scanner.nextInt();
			if (k != 0)
				queue.add(k);
		} while (k != 0);
		int p = 1;
		while ((k = queue.poll()) != null) {
			p *= k;
			System.out.print(k + " ");
		}
		System.out.println();
		System.out.println(p);
	}

}
