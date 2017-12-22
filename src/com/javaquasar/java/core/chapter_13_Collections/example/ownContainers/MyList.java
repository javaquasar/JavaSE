package com.javaquasar.java.core.chapter_13_Collections.example.ownContainers;

import java.util.AbstractList;

public class MyList extends AbstractList<String> {
	String[] arr = { "one", "two", "three" };

	@Override
	public String get(int index) {
		return arr[index];
	}

	@Override
	public int size() {
		return arr.length;
	}

	public static void main(String[] args) {
		MyList list = new MyList();
		for (String elem : list)
			System.out.println(elem);
		System.out.println(list.subList(0, 2)); // [one, two]
		System.out.println(list.indexOf("two")); // 1
		list.add("four"); // ���������� "UnsupportedOperationException"
	}
}