package core.lecture3_05_IO_Stream.practice.task_5_05;

import java.io.Serializable;

public class Group<T> implements Serializable {

	private static final long serialVersionUID = 4433147861334322335L;
	private String name;
	private Object[] students;
	public Group(String name, T... students) {
		this.name = name;
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public University[] getStudents() {
		return (University[]) students;
	}
	public void setStudents(University[] students) {
		this.students = students;
	}
	
	
}
