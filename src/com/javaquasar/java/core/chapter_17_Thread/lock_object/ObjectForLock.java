package com.javaquasar.java.core.chapter_17_Thread.lock_object;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ObjectForLock {
	
	public synchronized void printOne() {
		while(true) {
			
			System.out.println("printOne");
		}
	}
	
	public synchronized void printTwo() {
		while(true) {
			System.out.println("printTwo");
		}
	}

}
