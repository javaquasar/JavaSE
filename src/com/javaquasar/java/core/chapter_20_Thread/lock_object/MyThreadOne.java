package com.javaquasar.java.core.chapter_20_Thread.lock_object;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class MyThreadOne implements Runnable{
	
	private ObjectForLock lock = null;
	
	public MyThreadOne(ObjectForLock lock) {
		this.lock = lock;
		new Thread(this).start();
	}

	@Override
	public void run() {
		lock.printOne();
	}
}
