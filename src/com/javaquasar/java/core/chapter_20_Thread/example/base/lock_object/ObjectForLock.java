package com.javaquasar.java.core.chapter_20_Thread.example.base.lock_object;

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
