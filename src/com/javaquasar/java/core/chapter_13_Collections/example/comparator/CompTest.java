package com.javaquasar.java.core.chapter_13_Collections.example.comparator;

import java.util.*;

public class CompTest {

	public static void main(String args[]) {

		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		ts.add("C");
		ts.add("E");
		ts.add("D");
		ts.add("B");
		ts.add("A");
		ts.add("F");
		for (String element : ts)
			System.out.print(element + " ");
	}
}
