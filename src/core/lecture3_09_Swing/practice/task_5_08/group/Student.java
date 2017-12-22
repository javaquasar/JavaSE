package core.lecture3_09_Swing.practice.task_5_08.group;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 2433147861334322335L;
	private String name, surname;
	private int year;
	
	public Student() {
		
	}
	
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
