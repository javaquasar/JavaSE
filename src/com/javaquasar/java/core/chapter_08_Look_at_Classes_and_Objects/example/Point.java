package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

public class Point {
	double x, y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double distance() {
		return Math.sqrt(x * x + y * y);
	}

	static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
				* (p1.y - p2.y));
	}

	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
		System.out.println(p1.distance());
		Point p2 = new Point(4, 5);
		System.out.println(distance(p1, p2));
	}
}
