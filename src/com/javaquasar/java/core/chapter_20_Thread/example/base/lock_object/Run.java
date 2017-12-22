package com.javaquasar.java.core.chapter_20_Thread.example.base.lock_object;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Run {

	public static void main(String[] args) {
		ObjectForLock lock = new ObjectForLock();

		new MyThreadOne(lock);
		
		new MyThreadTwo(lock);

	}

}
