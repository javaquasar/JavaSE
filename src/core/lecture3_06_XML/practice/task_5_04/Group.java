package core.lecture3_06_XML.practice.task_5_04;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 4433147861334322335L;
	private String name;
	private Student[] students;
	
	public Group() {
		//для сериализации в XML обязательно нужен конструктор без параметров
	}

	public Group(String name, Student... students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

}
