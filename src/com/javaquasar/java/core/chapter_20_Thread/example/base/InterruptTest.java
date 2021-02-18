package com.javaquasar.java.core.chapter_20_Thread.example.base;

import java.util.Scanner;

public class InterruptTest implements Runnable {

	@Override
	public void run() {
		for (int counter = 1; counter <= 40; counter++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Поток прерван.");
				break;
			}
			System.out.println(counter);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Thread thread = new Thread(new InterruptTest());
		thread.start();
		System.out.println("Для прерывания нажмите Enter");
		new Scanner(System.in).nextLine();
		thread.interrupt();
	}

}
