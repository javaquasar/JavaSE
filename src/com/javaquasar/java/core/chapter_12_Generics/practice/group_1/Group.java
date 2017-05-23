package com.javaquasar.java.core.chapter_12_Generics.practice.group_1;

/**
 * Created by Java Quasar on 16.05.17.
 */
public abstract class Group extends Student {
	public abstract void addStudent(Student stud);
	public abstract Student getStudent(int index);
	public abstract void deleteStudent(int index);
	public abstract int getAmountOfStudents();
	public abstract void sortList();
}


