package com.javaquasar.java.core.chapter_13_Collections.map;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by Java Quasar on 16.05.17.
 */
class DogWithoutHash {
	String color;
 
	DogWithoutHash(String c) {
		color = c;
	}
	public String toString(){	
		return color + " dog";
	}
}

public class TestHashMapBad {
	public static void main(String[] args) {
		HashMap<DogWithoutHash, Integer> hashMap = new HashMap<DogWithoutHash, Integer>();
		DogWithoutHash d1 = new DogWithoutHash("red");
		DogWithoutHash d2 = new DogWithoutHash("black");
		DogWithoutHash d3 = new DogWithoutHash("white");
		DogWithoutHash d4 = new DogWithoutHash("white");

		hashMap.put(d1, 10);
		System.out.println("Если null - то такого элемента не было " + hashMap.put(d2, 15));
		hashMap.put(d3, 5);
		System.out.println("Если есть совпадение - возвращает совпдающее значение " + hashMap.put(d4, 20));

		// print size
		System.out.println("Размер - " + hashMap.size());

		// loop HashMap
		for (Entry<DogWithoutHash, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
		}
	}
}
