package com.javaquasar.java.core.chapter_16_IO_Stream.serialization;

import java.io.Serializable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SerializableEmploee implements Serializable {

	private static final long serialVersionUID = -6496944385261229833L;
	
	private String name = null;
	private int age;
	private double salary;
	
	public SerializableEmploee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	} 
	
	public void showDetails() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("salary: " + salary);
	}
	
	

}
