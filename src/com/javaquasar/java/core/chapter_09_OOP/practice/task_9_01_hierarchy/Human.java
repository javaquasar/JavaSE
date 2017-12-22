package com.javaquasar.java.core.chapter_09_OOP.practice.task_9_01_hierarchy;

public class Human {
	String name = "";
	String surName = "";
	int age = 0;

	public Human(String name, String surName, int age) {
		super();
		this.name = name;
		this.surName = surName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	@Override
	public String toString() {
		return "Человек, имя: " + name + ", фамилия: " + surName
				+ ", возраст: " + age;
	}
}
