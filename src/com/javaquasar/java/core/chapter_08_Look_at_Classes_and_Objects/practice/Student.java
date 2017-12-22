package com.javaquasar.java.core.chapter_08_Look_at_Classes_and_Objects.practice;

public class Student {
   
	private String name = "";
	private String lastName = "";
	private int year = 0;
	private String address = "";
	private String comment = "";
	
	public Student(String name, String lastName, int year, String address, String comment) {
		this.setName(name);
		this.setLastName(lastName);
		this.setYear(year);
		this.address = address;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
