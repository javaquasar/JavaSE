package com.javaquasar.java.core.chapter_20_Thread.count_down_latch;

import java.util.concurrent.*;
import java.lang.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*CountDownLatch (защелка с обратным отсчетом)

 Данная утилита предоставляет возможность одному потоку ожидать выполнение до тех пор, 
 пока не выполнится одно или несколько событий. Рассмотрим пример. Пускай один поток 
 отвечает за оповещение пользователя об окончании определенных действий, а второй поток 
 выполняет их.

 С начало в программе создается объект «защелка» который передает в конструктор значение 
 пять. Данное число указывает, что должно произойти 5 событий. Затем создается два потока 
 класса Echoable и Massager. Первый поток выводит значение локальной переменной, после 
 чего выполняется уменьшение счетчика событий на 1 (вызов метода countDown класса 
 CountDownLatch). Тем временем в классе Massager вызывается метод await который заставляет 
 приостановить поток, до того момента, пока счетчик событий не станет равен нулю. После 
 чего он может продолжить свою работу. Поэтому после того как выполняется 5 итераций метода 
 countDown защелка снимется и даст возможность потоку Massager продолжить свою работу.

 CountDownLatch имеет один конструктор, которому необходимо передать количество событий. 
 Одно выполненное событие равно одному вызову метода counDown() - данный метод ничего не 
 возвращает, и ничего не принимает. Чтобы поток заставить ждать окончания всех событий, 
 необходимо вызвать метод await. Данный метод имеет две формы.

 void await() throws InterruptedException 
 boolean await(long сколько, TimeUnit tu) throws InterruptedException 
 Первая форма заставляет просто ждать поток окончания событий (события). Вторая форма 
 позволяет указать время ожидания. Класс TimeUnit будет расмотрен в конце статьи.*/

class Echoable implements Runnable {
	private CountDownLatch count;

	Echoable(CountDownLatch count) {
		this.count = count;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			count.countDown();
		}
	}
}

class Massager implements Runnable {
	private CountDownLatch count;

	Massager(CountDownLatch count) {
		this.count = count;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			count.await();
		} catch (InterruptedException e) {
		}
		System.out.println("End...");
	}
}

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		CountDownLatch cdl = new CountDownLatch(5);
		new Echoable(cdl);
		new Massager(cdl);
	}
}
/*
 * Вывод программы Start 0 1 2 3 4 End...
 */
