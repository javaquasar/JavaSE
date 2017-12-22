package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.simultaneous_start;

import java.util.Random;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Ну а теперь начинается самое интересное. После инициализации semaphores 
 * в методе main идут 2 synchronized блока. Первый синхронизирует по классу 
 * Simultaneous, а второй захватывает монитор переменной semaphores.
 * 
После создания каждого потока-демона и его запуска посредством метода start(), 
выполнение потоков приостанавливается при входе в synchronized блок метода run(). 
Это происходит потому, что переменная semaphores “удерживается” в главном потоке 
(метод main). Как только все 10 потоков будут созданы, выполнение программы перейдет 
к циклу while. Задача этого цикла - отследить тот момент времени, когда все потоки 
будут запущены. Посредством метода wait текущий поток “отпускает” переменную 
semaphores (монитор объекта). В этот момент один из подопытных потоков заходит в 
synchronized блок метода run(). После инициализации потоком семафора, он отдает 
монитор semaphores главному потоку с помощью метода notify(). Так повторяется до 
тех пор, пока все семафоры не будут установлены в true, что и проверяется в 
последнем цикле synchronized блока.*/

public class Simultaneous implements Runnable {
	protected static final int THREADS = 10;

	private static class Semaphore {
		public boolean set = false;
	}

	protected static final Semaphore[] semaphores = new Semaphore[THREADS];
	protected static final Thread[] threads = new Thread[THREADS];

	protected static Random rnd = new Random();

	protected final int threadNum;

	protected Simultaneous(int num) {
		this.threadNum = num;
	}

	protected static int getRndNumber() {
		return rnd.nextInt(1000) * 10;
	}

	public void run() {
		synchronized (semaphores) {
			semaphores[this.threadNum].set = true;
			semaphores.notify();
		}

		final long startExec = System.currentTimeMillis();
		executeTask();
		final long finishExec = System.currentTimeMillis();
		System.out.println("Thread N" + this.threadNum + ". Start: " + startExec + ". End: " + finishExec + ". Total: " + (finishExec - startExec) + ".");
	}

	public void executeTask() {
		int temp = 1000;
		for (int i = 0; i < getRndNumber(); i++)
			for (int j = 0; j < getRndNumber(); j++)
				for (int k = 0; k < getRndNumber(); k++)
					temp = temp / temp * temp;
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREADS; i++) {
			semaphores[i] = new Semaphore();
		}

		System.out.println("Starting " + THREADS + " threads...");

		synchronized (Simultaneous.class) {
			synchronized (semaphores) {
				for (int i = 0; i < THREADS; i++) {
					final Simultaneous mainThread = new Simultaneous(i);
					threads[i] = new Thread(mainThread, "Thread N" + i);
					threads[i].setDaemon(true);
					threads[i].start();
				}

				System.out.println("Waiting for simultaneous start...");

				boolean isAllStarted = false;
				while (!isAllStarted) {
					try {
						semaphores.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					isAllStarted = true;
					for (int i = 0; i < THREADS; i++) {
						if (!semaphores[i].set) {
							isAllStarted = false;
							break;
						}
					}
				}
			}
		}

		System.out.println("Waiting for threads to finish execution...");

		for (int i = 0; i < THREADS; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}

		System.out.println("Program terminated successfully.");
	}
}
