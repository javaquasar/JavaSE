package com.javaquasar.java.core.chapter_20_Thread.blocking_queue;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Интерфейс BlockingQueue является очередью (Queue), т.е. его 
 * элементы хранятся в порядке «первый пришел, первый вышел» 
 * (FIFO – first in, first out). Элементы, вставленные в коллекцию 
 * в определенном порядке, будут извлечены из нее в том же 
 * самом порядке. Также интерфейс гарантирует, что любая попытка 
 * извлечь элемент из пустой очереди заблокирует вызывающий поток 
 * до тех пор, пока в коллекции не появится элемент, который 
 * можно извлечь. Аналогично, любая попытка вставить элемент в 
 * заполненную очередь заблокирует вызывающий поток, пока в 
 * коллекции не освободится место для нового элемента.
 * 
 * BlockingQueue изящно решает проблему передачи элементов, собранных 
 * одним потоком, для обработки в другой поток без явных хлопот о 
 * проблемах синхронизации. Хорошим примером является способ 
 * Guarded Blocks из официального руководства Java. В нем создается 
 * ограниченный буфер с одним слотом, после чего потоки, используя 
 * ручную синхронизацию и методы wait()/notifyAll(), сигнализируют друг 
 * другу, когда в слоте имеется новый элемент для обработки и когда 
 * слот готов к помещению в него нового элемента 
 * (cм. подробности в реализации Guarded Blocks).
 * 
 * Хотя код из руководства Guarded Blocks работает, он выглядит 
 * длинным, путаным и не вполне интуитивно понятным. В начале 
 * развития платформы Java разработчикам приходилось иметь дело с 
 * подобным кодом, однако сейчас 2010 год – наверняка положение 
 * дел улучшилось?
 * 
 * В листинге 1 показана переписанная версия кода Guarded Blocks, 
 * где я использую ArrayBlockingQueue вместо написанного вручную типа Drop.*/

/*Интерфейс ArrayBlockingQueue также уважает "честность", т.е. он может 
 * давать потокам чтения и записи доступ согласно принципу «первый пришел, 
 * первый вышел». Альтернативой этому может быть более эффективная политика, 
 * в которой допускается риск простаивания некоторых потоков. 
 * (А именно, было бы более эффективным позволять потокам чтения выполняться 
 * в то время, когда другие потоки чтения владеют блокировкой, но в такой 
 * стратегии есть риск того, что постоянная вереница потоков чтения не позволит 
 * потокам записи когда-либо выполнить свою работу).
 */
/*Опасайтесь ошибки!
 Кстати, если вы заметили, что в реализации Guarded Blocks имеется огромная ошибка, 
 – вы правы. Что бы случилось, если бы разработчик синхронизировал экземпляр 
 класса Drop в методе main()?*/
/*BlockingQueue также поддерживает методы, принимающие параметр time, обозначающий, 
 * как долго потоки должны пребывать в блокированном состоянии перед тем как вернуть 
 * управление, сигнализируя о том, что добавление или извлечение элемента не удалось. 
 * Это позволяет избежать неограниченного ожидания, которое может привести к 
 * катастрофе в рабочей системе, а также легко может "подвесить" систему и принудить к перезагрузке.*/

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

public class ABQApp {
	public static void main(String[] args) {
		BlockingQueue<String> drop = new ArrayBlockingQueue(1, true);
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
