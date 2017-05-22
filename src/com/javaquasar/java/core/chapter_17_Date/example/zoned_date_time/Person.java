package com.javaquasar.java.core.chapter_17_Date.example.zoned_date_time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
   
	private String name = "";
	private String lastName = "";
	Calendar data = GregorianCalendar.getInstance();
	private String address = "";
	
	@SuppressWarnings("deprecation")
	public Person(String name, String lastName, int year, int month, int day, String address) {
		this.setName(name);
		this.setLastName(lastName);
		//data.set(Calendar.MONTH, Calendar.JULY);
		//data.set(Calendar.DAY_OF_MONTH, 15);
		//data.set(Calendar.YEAR, 1978);
		data.set(year, month, day);
		this.address = address;
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
		return data.get(Calendar.YEAR);
	}

	public void setYear(int year) {
		data.set(Calendar.YEAR, year);
	}
	
	public int getMonth() {
		return data.get(Calendar.MONTH);
	}

	public void setMonth(int month) {
		data.set(Calendar.MONTH, month);
	}
	
	public int getDay() {
		return data.get(Calendar.DAY_OF_MONTH);
	}

	public void setDay(int day) {
		data.set(Calendar.DAY_OF_MONTH, day);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge(){
		final Calendar now = Calendar.getInstance();

	    int edadAnios = now.get(Calendar.YEAR) - data.get(Calendar.YEAR);
	    int edadMeses = now.get(Calendar.MONTH) - data.get(Calendar.MONTH);
	    int edadDias = now.get(Calendar.DAY_OF_MONTH) - data.get(Calendar.DAY_OF_MONTH);

	    if (edadDias < 0) {
	        edadMeses--;
	        if (edadMeses - 1 < 0)
	            edadMeses += 12;
	            edadAnios--;
	    }
	    if (edadMeses < 0) {
	        if (edadMeses < 0)
	            edadAnios--;
	    }

	    return edadAnios;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(getName());
		stringBuilder.append(" ");
		stringBuilder.append(getLastName());
		stringBuilder.append(" ");
		stringBuilder.append("Возраст - ");
		stringBuilder.append(getAge());
		stringBuilder.append("\n");
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Person person1 = new Person("Артур", "Базур", 1990, Calendar.JANUARY, 7, "Харьков");
		System.out.println(person1);
		person1.setDay(6);
		System.out.println(person1);
		
	}
	
}
