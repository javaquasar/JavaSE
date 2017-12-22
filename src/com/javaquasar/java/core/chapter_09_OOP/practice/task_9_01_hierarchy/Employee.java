package com.javaquasar.java.core.chapter_09_OOP.practice.task_9_01_hierarchy;

public abstract class Employee extends Citizen {

	public Employee(String name, String surName, int age, String registration) {
		super(name, surName, age, registration);
	}

	abstract double getSallary();

	abstract void payroll();

}
