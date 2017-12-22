package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

class Rectangle {
	double width;
	double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	Rectangle() {
		this(10, 20); // вызов другого конструктора
	}
}
