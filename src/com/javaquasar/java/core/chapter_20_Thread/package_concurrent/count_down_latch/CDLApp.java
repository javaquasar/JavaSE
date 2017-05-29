package com.javaquasar.java.core.chapter_20_Thread.package_concurrent.count_down_latch;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Если Semaphore – это параллельный класс, предназначенный для того, чтобы 
 * позволить потокам "заходить по одному" (возможно, напоминая "вышибал" 
 * из популярных ночных клубов), то CountDownLatch напоминает стартовый 
 * барьер на скачках. Этот класс задерживает все потоки до тех пор, пока 
 * не будет выполнено определенное условие. При выполнении условия он 
 * освобождает все потоки одновременно (листинг 2).*/

/*Обратите внимание, что в листинге 2 "защелки" CountDownLatch служит двум целям. 
 * Во-первых, одна защелка освобождает все потоки одновременно, имитируя старт 
 * скачек, однако позднее другая защелка имитирует окончание гонки, чтобы основной 
 * поток мог вывести на экран результаты. Чтобы добавить в "скачки" большее количество 
 * комментариев, можно добавить защелки CountDownLatch на промежуточных этапах, 
 * когда "лошади" проходят четверть, половину и три четверти дистанции.*/

class Race {
	private Random rand = new Random();

	private int distance = rand.nextInt(250);
	private CountDownLatch start;
	private CountDownLatch finish;

	private List<String> horses = new ArrayList<String>();

	public Race(String... names) {
		this.horses.addAll(Arrays.asList(names));
	}

	public void run() throws InterruptedException {
		System.out.println("And the horses are stepping up to the gate...");
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch finish = new CountDownLatch(horses.size());
		final List<String> places = Collections.synchronizedList(new ArrayList<String>());

		for (final String h : horses) {
			new Thread(new Runnable() {
				public void run() {
					try {
						System.out.println(h + " stepping up to the gate...");
						start.await();

						int traveled = 0;
						while (traveled < distance) {
							// через 0-2 секунды....
							Thread.sleep(rand.nextInt(3) * 1000);

							// ... лошадь проходит дистанцию 0-14 пунктов
							traveled += rand.nextInt(15);
							System.out.println(h + " advanced to " + traveled + "!");
						}
						finish.countDown();
						System.out.println(h + " crossed the finish!");
						places.add(h);
					} catch (InterruptedException intEx) {
						System.out.println("ABORTING RACE!!!");
						intEx.printStackTrace();
					}
				}
			}).start();
		}

		System.out.println("And... they're off!");
		start.countDown();

		finish.await();
		System.out.println("And we have our winners!");
		System.out.println(places.get(0) + " took the gold...");
		System.out.println(places.get(1) + " got the silver...");
		System.out.println("and " + places.get(2) + " took home the bronze.");
	}

	public String getDistance() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class CDLApp {
	public static void main(String[] args) throws InterruptedException, java.io.IOException {
		System.out.println("Prepping...");

		Race r = new Race("Beverly Takes a Bath", "RockerHorse", "Phineas", "Ferb", "Tin Cup", "I'm Faster Than a Monkey", "Glue Factory Reject");

		System.out.println("It's a race of " + r.getDistance() + " lengths");

		System.out.println("Press Enter to run the race....");
		System.in.read();

		r.run();
	}
}
