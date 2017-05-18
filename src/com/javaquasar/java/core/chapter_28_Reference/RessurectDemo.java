package com.javaquasar.java.core.chapter_28_Reference;

import java.lang.ref.PhantomReference;

import java.lang.ref.Reference;

import java.lang.ref.ReferenceQueue;

/*Использование PhantomReference*/

/*Разберемся теперь с тем, как использовать фантомные ссылки. Удобный способ получить 
 * уведомление о помещении ссылки в очередь - создать отдельный поток, который будет 
 * периодически опрашивать данную очередь, вызывая метод ReferenceQueue#poll(). Данный 
 * метод возвращает ссылку в случае ее наличия в очереди или null - в случае отсутствия. 
 * Поместить код данного потока и механизмы его запуска удобнее всего в класс-наследник 
 * PhantomReference. Так же в данном наследнике можно создать метод, осуществляющий 
 * действия по очистке системы после удаления объекта - те действия, которые раньше 
 * размещались в методе finalize(). К таким действиям относятся: закрытие соединений, 
 * сбрасывание состояния объекта на диск, освобождение сессий и т.д. Стоит отметить, 
 * что для выполнения некоторых действий могут понадобиться знания о внутреннем состоянии 
 * объекта. Ни в коем случае нельзя сохранять объект как поле в классе-наследнике 
 * PhantomReference, т.к. в таком случае будет создана жесткая ссылка на данный объект, 
 * т.е. при сборке мусора с ним не будет выполняться никаких действий. Необходимо 
 * сохранять в классе-наследнике PhantomReference значения только тех полей объекта, 
 * которые будут нужны для проведения процедуры очистки.*/

/*Итак, стратегия использования PhantomReference может быть следующей:*/

/*Создаем класс-наследник PhantomReference. В данном классе реализуем метод, осуществляющий 
 * очистку окружения после удаления объекта.*/

/*Создаем класс-поток, в конструктор которого передается очередь ReferenceQueue, связанная 
 * с экземпляром созданного ранее класса PhantomReference. В методе run() данного потока 
 * реализуем опрос этой очереди. Как только из ReferenceQueue будет считано непустое 
 * значение - вызываем метод класса-наследника PhantomReference, осуществляющий очистку 
 * окружения.*/

/*В конструкторе класса-наследника PhantomReference сохраняем значения нужных в дальнейшем 
 * полей переданного объекта после чего запускаем поток, созданный на втором шаге алгоритма.*/

/*Описанная стратегия иллюстрируется следующим кодом:*/

public class RessurectDemo {

	private A a;

	public static class A {

		private RessurectDemo demo;

		private String data;

		public String getData() {

			return data;

		}

		public A(RessurectDemo demo) {

			this.demo = demo;

			StringBuffer buff = new StringBuffer();

			for (long i = 0; i < 50000000; i++) {

				buff.append('a');

			}

			this.data = buff.toString();

		}

		@Override
		protected void finalize() throws Throwable {

			System.out.println("A.finalize()");

		}

	}

	private static class MyPhantomReference<T> extends PhantomReference<T> {

		public MyPhantomReference(T obj, ReferenceQueue<? super T> queue) {

			super(obj, queue);

			Thread thread = new MyPollingThread<T>(queue);

			thread.start();

		}

		public void cleanup() {

			System.out.println("cleanup()");

			// Clear Reference!!!

			clear();

		}

		public static class MyPollingThread<T> extends Thread {

			private ReferenceQueue<? super T> referenceQueue;

			public MyPollingThread(ReferenceQueue<? super T> referenceQueue) {

				this.referenceQueue = referenceQueue;

			}

			@Override
			public void run() {

				System.out.println("MyPollingThread started");

				Reference<?> ref = null;

				while ((ref = referenceQueue.poll()) == null) {

					try {

						Thread.sleep(50);

					}

					catch (InterruptedException e) {

						throw new RuntimeException("Thread " + getName() + " has been interrupted");

					}

				}

				if (ref instanceof MyPhantomReference<?>) {

					((MyPhantomReference<?>) ref).cleanup();

				}

			}

		}

	}

	public static void main(String[] args) throws InterruptedException {

		RessurectDemo demo = new RessurectDemo();

		Thread.sleep(20000);

		Reference<A> ref = new MyPhantomReference<RessurectDemo.A>(new A(demo), new ReferenceQueue<RessurectDemo.A>());

		System.out.println("ref = " + ref);

		System.out.println("A = " + ref.get());

		Thread.sleep(10000);

		System.out.println("System.gc()");

		System.gc();

		Thread.sleep(400);

		System.out.println("ref = " + ref);

		System.out.println("A = " + ref.get());

		Thread.sleep(10000);

		System.out.println("System.gc()");

		System.gc();

		Thread.sleep(400);

		Thread.sleep(10000);

		System.out.println("System.gc()");

		System.gc();

		Thread.sleep(10000);

	}

}
