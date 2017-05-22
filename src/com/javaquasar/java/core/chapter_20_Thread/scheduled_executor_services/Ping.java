package com.javaquasar.java.core.chapter_20_Thread.scheduled_executor_services;

import java.util.concurrent.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Интерфейс ExecutorService хорош, однако он не подходит для случая, 
 * когда некоторые задачи необходимо делать по расписанию, например 
 * выполнять что-то через определенные интервалы времени или в 
 * заданное время. Здесь пригодится класс ScheduledExecutorService, 
 * расширяющий класс ExecutorService.
 * 
 * Если бы вам было нужно написать команду, отображающую "сердцебиение" 
 * программы, которая бы выполнялась каждые пять секунд, с помощью 
 * ScheduledExecutorService это можно было бы сделать очень просто, 
 * например так, как показано в листинге 4.*/

public class Ping {
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		Runnable pinger = new Runnable() {
			public void run() {
				System.out.println("PING!");
			}
		};
		ses.scheduleAtFixedRate(pinger, 5, 5, TimeUnit.SECONDS);
	}
}
