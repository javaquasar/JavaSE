package com.javaquasar.java.core.chapter_20_Thread.example.package_concurrent.semaphore;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*В некоторых корпоративных системах разработчикам нередко нужно 
 * ограничивать количество открытых запросов (потоков/действий), 
 * использующих определенный ресурс. На самом деле такое ограничение 
 * может иногда улучшить производительность системы, снижая 
 * конкуренцию за данный ресурс. Конечно, можно попытаться вручную 
 * написать осуществляющий регулировку код, однако легче 
 * использовать класс semaphore, который позаботится о регулировке 
 * за вас. */


/*Хотя в этом примере выполняется 10 потоков (в чем можно убедиться, 
 * выполнив для процесса, в котором работает SemApp, команду jstack), 
 * только три из них являются активными. Остальные семь вынуждены 
 * ждать, пока какой-нибудь из выполняющихся потоков не освободит 
 * семафор. (В действительности класс Semaphore поддерживает захват 
 * и освобождение более чем одного разрешения за раз, но в данном 
 * сценарии это не имеет смысла).*/

public class SemApp {
	public static void main(String[] args) {
		Runnable limitedCall = new Runnable() {
			final Random rand = new Random();
			final Semaphore available = new Semaphore(3);
			int count = 0;

			public void run() {
				int time = rand.nextInt(15);
				int num = count++;

				try {
					available.acquire();

					System.out.println("Executing " + "long-running action for " + time + " seconds... #" + num);

					Thread.sleep(time * 1000);

					System.out.println("Done with #" + num + "!");

					available.release();
				} catch (InterruptedException intEx) {
					intEx.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 10; i++)
			new Thread(limitedCall).start();
	}
}
