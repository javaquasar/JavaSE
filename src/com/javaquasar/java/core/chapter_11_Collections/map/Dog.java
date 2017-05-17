package com.javaquasar.java.core.chapter_11_Collections.map;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Dog {
	String color;

	Dog(String c) {
		color = c;
	}

	public boolean equals(Object o) {
		return ((Dog) o).color.equals(this.color);
	}

	public int hashCode() {
		return color.length();
	}

	public String toString() {
		return color + " dog";
	}
}

