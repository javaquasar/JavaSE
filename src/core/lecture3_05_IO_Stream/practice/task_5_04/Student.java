package core.lecture3_05_IO_Stream.practice.task_5_04;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 2433147861334322335L;
	private String name;
	private String lastname;
	private String group;
	private String cours;

	public Student(String name, String lastname, String group, String cours) {
		this.name = name;
		this.lastname = lastname;
		this.group = group;
		this.cours = cours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}

}
