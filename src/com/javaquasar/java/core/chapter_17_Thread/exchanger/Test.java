package com.javaquasar.java.core.chapter_17_Thread.exchanger;

import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Exchanger (обменик)

 У программиста может возникнуть ситуация когда два потока тесно связаны между собой. 
 Предположим один поток формирует данные, а другой записует эти данные в файл. Поэтому 
 первый поток передает данные второму потоку. Пока поток 1 формирует данные, поток 2 
 занимается созданием файла, проверкой и т.п. Для того, чтобы передать данные с одного 
 потока в другой поток в определенной точки работы обоих потоков, используется 
 специализированная утилита «обменик».

 Для понимания данного класса достаточно запомнить, что данный класс является обобщенным. 
 В качестве параметризатора указывается тип передаваемых данных. У данного класса нету 
 конструкторов, но есть один перегруженный метод, который и используется для передачи.

 V exchange(V объект) throws InterruptedException 
 V exchange(V обхект, long время, TimeUnit tu) throws InterruptedException, TimeoutException. 
 Первому параметру должна передаваться ссылка на объект, который будет передан другому потоку.

 Пока Writeable создает файл и буфер символьного потока, первый поток формирует строку. 
 После этого строка из потока Sendable передается потоку Writeable. Важной особенностью 
 является то, что первый поток не отправляет данные сразу, несмотря на то, что формирование 
 данных он закончил. Обменник производит обмен только в тех точках, где они вызваны. 
 Соответственно, данные не передаются в Writeable до тех пор пока не покажется вызов 
 метода exchange (также работа потока приостанавливается, пока данные не будут переданы ).

 */

class Sendable implements Runnable {
	private Exchanger<String> exch;
	private String str;

	Sendable(Exchanger<String> exch) {
		this.exch = exch;
		new Thread(this).start();
	}

	@Override
	public void run() {
		str = "Test Exchanger";
		try {
			str = exch.exchange(str);
		} catch (Exception e) {
		}
	}
}

class Writeable implements Runnable {
	private Exchanger<String> exch;
	private String str;

	Writeable(Exchanger<String> exch) {
		this.exch = exch;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			FileWriter f = new FileWriter("X://index.txt");
			BufferedWriter out = new BufferedWriter(f);
			str = exch.exchange(new String());
			out.write(str);
			out.close();
		} catch (Exception e) {

		}
	}
}

public class Test {
	public static void main(String[] args) {
		Exchanger<String> exch = new Exchanger<String>();
		new Sendable(exch);
		new Writeable(exch);
	}
}

/*
 * Запись строки в файл
 */
