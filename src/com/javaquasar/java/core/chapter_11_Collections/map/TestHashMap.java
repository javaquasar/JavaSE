package com.javaquasar.java.core.chapter_11_Collections.map;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestHashMap {
	public static void main(String[] args) {
		HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");

		hashMap.put(d1, 10);
		System.out.println("Если null - то такого элемента не было " + hashMap.put(d2, 15));
		hashMap.put(d3, 5);
		System.out.println("Если есть совпадение - возвращает совпдающее значение " + hashMap.put(d4, 20));

		// print size
		System.out.println("Размер - " + hashMap.size());

		// loop HashMap
		for (Entry<Dog, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
		}
	}
}
