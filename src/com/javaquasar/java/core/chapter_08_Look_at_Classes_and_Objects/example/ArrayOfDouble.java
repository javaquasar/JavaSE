package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.example;

public class ArrayOfDouble {
	private double[] a;

	public ArrayOfDouble() {
		a = null;
	}

	public ArrayOfDouble(int n) {
		a = new double[n];
	}

	public ArrayOfDouble(double[] a) {
		this.a = a;
	}

	int size() {
		return a != null ? a.length : 0;
	}

	public double[] toArray() {
		return a;
	}

	public void setA(double[] a) {
		this.a = a;
	}

	public double get(int i) {
		return a[i];
	}

	public void set(int i, double x) {
		a[i] = x;
	}

	public void add(double x) {
		double[] b = new double[size() + 1];
		if (a != null)
			System.arraycopy(a, 0, b, 0, size());
		b[size()] = x;
		a = b;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < size(); i++) {
			s += (a[i] + " ");
		}
		s = s.trim() + "]";
		return s;
	}

	public static void main(String[] args) {
		ArrayOfDouble arr = new ArrayOfDouble(new double[] { 1, 2, 3 });
		System.out.println(arr.get(0));
		System.out.println(arr.toArray()[2]);
		System.out.println(arr);
		arr.set(1, 0);
		arr.toArray()[2] = 4;
		arr.add(5);
		System.out.println(arr);
		arr = new ArrayOfDouble();
		System.out.println(arr);
		arr.add(1);
		System.out.println(arr);
	}
}
