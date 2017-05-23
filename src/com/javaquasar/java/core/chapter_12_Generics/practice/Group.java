package com.javaquasar.java.core.chapter_12_Generics.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Java Quasar on 16.05.17.
 */
class Student {
    private String name;
    private int age;
    private int course;
    private String group;


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

}

abstract class Group extends Student implements Comparable<Group> {

    public abstract void addStudent(Student stud);

    public abstract Student getStudent(int index);

    public abstract void deleteStudent(int index);

    public abstract int getAmountOfStudents();
}


class StudentsWithArray extends Group {

    Student[] mainArray = new Student[0];

    @Override
    public int compareTo(Group o) {
        return getName().compareTo(o.getName());
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

}

class StudentsWithList extends Group {
    List<Student> mainList = new ArrayList<>();

    @Override
    public int compareTo(Group o) {
        return -Integer.compare(getAge(), o.getAge());
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

}

