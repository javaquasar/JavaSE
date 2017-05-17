package com.javaquasar.java.core.chapter_11_Collections.map;

import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Created by Java Quasar on 16.05.17.
 */
class DogCompar implements Comparable<DogCompar>{
	String color;
	int size;
 
	DogCompar(String c, int s) {
		color = c;
		size = s;
	}
 
	public String toString(){	
		return color + " dog";
	}
 
	@Override
	public int compareTo(DogCompar o) {
		return  o.size - this.size;
	}
}

public class TestTreeMapWithComparable {
	public static void main(String[] args) {
		DogCompar d1 = new DogCompar("red", 30);
		DogCompar d2 = new DogCompar("black", 20);
		DogCompar d3 = new DogCompar("white", 10);
		DogCompar d4 = new DogCompar("white", 10);
 
		TreeMap<DogCompar, Integer> treeMap = new TreeMap<DogCompar, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);
 
		for (Entry<DogCompar, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
