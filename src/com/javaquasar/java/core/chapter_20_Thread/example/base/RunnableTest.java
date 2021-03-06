package com.javaquasar.java.core.chapter_20_Thread.example.base;

public class RunnableTest implements Runnable {

	@Override
	public void run() {
		for (int counter = 1; counter <= 10; counter++) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(counter);
		}
	}

	public static void main(String[] args) {
		new Thread(new RunnableTest()).start();
		// Сюда можно добавить действия, выполняемые параллельно с методом run()
	}

}