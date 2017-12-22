package com.javaquasar.java.core.chapter_20_Thread.example.base.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TimeToRun {

	public static void main(String[] args) {
		int intervale = 10000; // 10 sec.
		Date timeToRun = new Date(System.currentTimeMillis() + intervale);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Hello " + new Date());
			}
		}, timeToRun);
	}

}
