package com.javaquasar.java.core.chapter_13_Collections.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestLinkedHashMap {
	public static void main(String[] args) {

		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");

		LinkedHashMap<Dog, Integer> linkedHashMap = new LinkedHashMap<Dog, Integer>();
		linkedHashMap.put(d1, 10);
		linkedHashMap.put(d2, 15);
		linkedHashMap.put(d3, 5);
		linkedHashMap.put(d4, 20);

		for (Entry<Dog, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
