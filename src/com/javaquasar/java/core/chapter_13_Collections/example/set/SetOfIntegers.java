package com.javaquasar.java.core.chapter_13_Collections.example.set;

import java.util.*;

public class SetOfIntegers {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Integer k = random.nextInt() % 10;
			set.add(k);
		}
		System.out.println(set);
	}

}
