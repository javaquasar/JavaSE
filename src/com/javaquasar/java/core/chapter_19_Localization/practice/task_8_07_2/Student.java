package com.javaquasar.java.core.chapter_19_Localization.practice.task_8_07_2;

public class Student {
	
	private String name, surname;
	private int year;
	
	public Student(String name, String surname, int year) {
		this.name = name;
		this.surname = surname;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return surname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
