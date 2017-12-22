package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.cyclic_barrier;

import java.util.concurrent.*;
import java.lang.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*CyclicBarrier (циклический барьер)

Данная утилита похожа на «защелку». Тем не менее они имеют различия. Циклический барьер 
позволяет определить объект синхронизации. Каждый поток выполняется параллельно, и как 
только каждый поток достигает барьерную точку, считается что цикл окончен.

Для начало нужно запомнить, что класс CyclicBarrier предоставляет 2 конструктора.

CyclicBarrier(int количество)
CyclicBarrier(int количество, Runnable действие)
Первая форма конструктора позволяет задать количество потоков которые должны дойти до 
барьерной точки. Вторая форма позволяет задать также действие, которое должно выполнится 
после достижения барьера всеми потоками. Второму параметру должен передаваться класс 
реализующий интерфейс Runnable. Поток НЕ НУЖНО ЗАПУСКАТЬ самостоятельно, данная утилита 
это делает автоматически после достижения барьера.

Для указания потоку о том что он достиг барьера, нужно вызвать метот await. Данный метод имеет две формы

void await() throws InterruptedException 
boolean await(long сколько, TimeUnit tu) throws InterruptedException, BrokenBarrierException, TimoutException. 
Для того, чтобы понять лучше работу данной утилиты рассмотрим пример.
Создается барьер, которому в конструктор передается 2 параметра. Первый указывает о том, 
что барьера должны достигнуть два потока, а вторым параметром передается объект класса 
Runnable который запускается каждый раз, когда 2 потока достигают барьер. Поэтому после 
выполнение двух потоков на терминал выводится уведомление о достижения барьерной точки 
потоками.*/

class CB implements Runnable {
	private String str;
	private CyclicBarrier c;

	CB(String str, CyclicBarrier c) {
		this.str = str;
		this.c = c;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(str);
		try {
			c.await();
		} catch (Exception e) {
		}
	}
}

class MyRun implements Runnable{
	public void run() {
		System.out.println("End CyclicBarrier");
	}
}

public class Test {
	public static void main(String[] args) throws Exception {
		
		CyclicBarrier demo = new CyclicBarrier(2, new MyRun());
		new CB("1", demo);
		new CB("2", demo);
		new CB("3", demo);
		new CB("4", demo);
		new CB("5", demo);
		new CB("6", demo);
		new CB("7", demo);
		new CB("8", demo);
	}
}
/*
 * Вывод: 1 2 End CyclicBarrier 3 4 End CyclicBarrier 5 6 End CyclicBarrier 7 8
 * End CyclicBarrier
 */
