package com.javaquasar.java.core.chapter_13_Collections.example.map;

import java.util.*;

public class TreeMapKey implements Comparable<TreeMapKey> {
	String name;

	public String getName() {
		return name;
	}

	private TreeMapKey(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(TreeMapKey o) {
		return name.substring(o.getName().indexOf(" ")).trim().compareToIgnoreCase(o.getName().substring(o.getName().indexOf(" ")).trim());
	}

	public static void main(String args[]) {
		TreeMap<TreeMapKey, Integer> tm = new TreeMap<TreeMapKey, Integer>();
		tm.put(new TreeMapKey("Петр Иванов"), new Integer(1982));
		tm.put(new TreeMapKey("Иван Петров"), new Integer(1979));
		tm.put(new TreeMapKey("Василий Сидоров"), new Integer(1988));
		tm.put(new TreeMapKey("Сидор Васильев"), new Integer(1980));
		for (Map.Entry<TreeMapKey, Integer> me : tm.entrySet()) {
			System.out.print(me.getKey().getName() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
	}

}
