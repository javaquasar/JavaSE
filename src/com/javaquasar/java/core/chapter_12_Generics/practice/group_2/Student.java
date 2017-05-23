package com.javaquasar.java.core.chapter_12_Generics.practice.group_2;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Student /*implements Comparable<Student>*/{
	private String name;
	private int age;
	private int course;
	private String group;
	
	/*@Override
	public int compareTo(Student o) {
		return getName().compareTo(o.getName());
	}*/
	
	/*@Override
	public int compareTo(Student o) {
		return -Integer.compare(getAge(), o.getAge());
	}*/

	public Student(String name, int age, int course, String group) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
		this.group = group;
	}

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return getName() + " Возраст " + getAge() + " Курс " + getCourse() + " Группа " + getGroup() + "\n";
	}

}
