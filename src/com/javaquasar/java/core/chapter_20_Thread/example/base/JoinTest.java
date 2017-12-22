package com.javaquasar.java.core.chapter_20_Thread.example.base;

public class JoinTest {
	static Thread t1, t2;

	static class FirstThread implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("Поток First запущен.");
				Thread.sleep(1000);
				System.out.println("Основная работа потока First завершена.");
				t2.join();
				System.out.println("Поток First заврешен.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class SecondThread implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("Поток Second запущен.");
				Thread.sleep(3000);
				System.out.println("Поток Second заврешен.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		t1 = new Thread(new FirstThread());
		t2 = new Thread(new SecondThread());
		t1.start();
		t2.start();
	}

}
