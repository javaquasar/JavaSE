package com.javaquasar.java.core.chapter_12_Generics.practice.group_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StudentsWithList extends Group {
	List<Student> mainList = new ArrayList<>();

	public List<Student> getListStudent() {
		return mainList;
	}
	
	@Override
	public void addStudent(Student stud) {
		mainList.add(stud);
	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index > mainList.size())
			throw new IndexOutOfBoundsException();
		return mainList.get(index);
	}

	@Override
	public void deleteStudent(int index) {
		mainList.remove(index);
	}

	@Override
	public int getAmountOfStudents() {
		return mainList.size();
	}
	
	@Override
	public void sortList() {
        Collections.sort(mainList);
    }

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("List of student\n");
		for(Student s : mainList) {
			stringBuilder.append(s.toString());
		}
		return stringBuilder.toString();
	}
}
