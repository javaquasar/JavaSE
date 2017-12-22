package com.javaquasar.java.core.chapter_19_Localization.practice.task_8_08;

import java.util.Arrays;

public class StudentWithArray extends AbstractStudent{
	private Student [] students = {}; 

	@Override
	public Student getStudent(int i) {
	    return students[i];
	}

	@Override
	public void setStudent(int i, Student student) {
	    students[i] = student;
	}

	@Override
	public int studentsCount() {
		return students == null ? 0 : students.length;
	}

	@Override
	public void addStudent(Student s) {
		Student[] temp = new Student[studentsCount() + 1]; 
		if (students != null) {
		   System.arraycopy(students, 0, temp, 0, students.length);
		}
		temp[studentsCount()] = s;
		students = temp;
	}
	
	@Override
	public void clearStudent() {
		students = null;
	}
	
	@Override
	public void sortSurnamesByAlphabet() {
		Arrays.sort(students, new CompareBySurname());
	}

	@Override
	public void sortYearDown() {
		Arrays.sort(students, new CompareByYear());
	}
	
	public static void main(String [] args) {
		new StudentWithArray().test();
	}
}
