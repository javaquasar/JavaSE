package com.javaquasar.java.core.chapter_12_Generics.practice.group_1;

import java.util.Arrays;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StudentsWithArray extends Group{
	private Student[] mainArray = new Student[0];
	
	public Student[] getArrayStudent() {
		return mainArray;
	}

	@Override
	public void addStudent(Student stud) {
		Student[] newMainArray = new Student[mainArray.length + 1];
		for (int i = 0; i < mainArray.length; i++) {
			newMainArray[i] = mainArray[i];
		}
		newMainArray[mainArray.length] = stud;
		mainArray = newMainArray;
	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index > mainArray.length)
			throw new IndexOutOfBoundsException();
		return mainArray[index];
	}

	@Override
	public void deleteStudent(int index) {
		if (index < 0 || index > mainArray.length)
			throw new IndexOutOfBoundsException();
		Student[] newMainArray = new Student[mainArray.length - 1];
		for (int i = 0; i < index; i++) {
			newMainArray[i] = mainArray[i];
		}
		int j = index;
		for (int i = index + 1; i < mainArray.length; i++) {
			newMainArray[j] = mainArray[i];
		}
		mainArray = newMainArray;

	}

	@Override
	public int getAmountOfStudents() {
		return mainArray.length;
	}
	
	@Override
	public void sortList() {
		Arrays.sort(mainArray);
    }
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Array of student\n");
		for(Student s : mainArray) {
			stringBuilder.append(s.toString());
		}
		return stringBuilder.toString();
	}
}
