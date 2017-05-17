package com.javaquasar.java.core.chapter_17_Thread.synchronous_queues;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*SynchronousQueue, согласно Javadoc, является довольно интересной сущностью.
 *Блокирующая очередь, в которой каждая операция добавления должна ждать 
 *соответствующей операции удаления в другом потоке и наоборот. Синхронная 
 *очередь не имеет никакой внутренней емкости, даже емкости в один элемент.
 *В сущности, SynchronousQueue – это еще одна реализация упомянутого выше 
 *интерфейса BlockingQueue. Она предоставляет необычайно легковесный способ 
 *обмена одиночными элементами между потоками посредством семантики блокировки, 
 *используемой в ArrayBlockingQueue. В листинге 2 я переписал код из 
 *листинга 1 с использованием SynchronousQueue вместо ArrayBlockingQueue.*/

/*Код этой реализации выглядит почти точно так же, однако у приложения появляется 
 * дополнительное преимущество: SynchronousQueue позволяет вставить элемент в 
 * очередь только в том случае, если имеется поток, ожидающий поступления элемента для обработки.*/

class Producer implements Runnable {
	private BlockingQueue<String> drop;
	List<String> messages = Arrays.asList("Mares eat oats", "Does eat oats", "Little lambs eat ivy", "Wouldn't you eat ivy too?");

	public Producer(BlockingQueue<String> d) {
		this.drop = d;
	}

	public void run() {
		try {
			for (String s : messages)
				drop.put(s);
			drop.put("DONE");
		} catch (InterruptedException intEx) {
			System.out.println("Interrupted! " + "Last one out, turn out the lights!");
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<String> drop;

	public Consumer(BlockingQueue<String> d) {
		this.drop = d;
	}

	public void run() {
		try {
			String msg = null;
			while (!((msg = drop.take()).equals("DONE")))
				System.out.println(msg);
		} catch (InterruptedException intEx) {
			System.out.println("Interrupted! " + "Last one out, turn out the lights!");
		}
	}
}

public class SynQApp {
	public static void main(String[] args) {
		BlockingQueue<String> drop = new SynchronousQueue<String>();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
