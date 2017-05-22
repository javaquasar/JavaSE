package com.javaquasar.java.core.chapter_20_Thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TimerDemo {
	
	public static void main(String[] args) {
		int delay = 5000; // delay for 5 sec.
		int period = 1000; // intervale every sec.
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Hello " + new Date());
			}
		}, delay, period);
	}

}
