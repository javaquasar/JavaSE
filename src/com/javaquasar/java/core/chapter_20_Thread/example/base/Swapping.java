package com.javaquasar.java.core.chapter_20_Thread.example.base;

public class Swapping implements Runnable {
	private static double[] a;
	private double[] arr;

	public Swapping(double... arr) {
		this.arr = arr;
	}

	public static synchronized void swap(double... arr) {
		a = new double[arr.length];
		System.arraycopy(arr, 0, a, 0, a.length);
		for (int i = 1; i < a.length; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double x = a[i - 1];
			a[i - 1] = a[i];
			a[i] = x;
		}
		System.arraycopy(a, 0, arr, 0, a.length);
	}

	@Override
	public void run() {
		swap(arr);
		for (double x : arr) {
			System.out.printf("%f ", x);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Swapping(1, 2, 3));
		t1.start();
		Thread t2 = new Thread(new Swapping(4, 5, 6, 7));
		t2.start();
	}

}
