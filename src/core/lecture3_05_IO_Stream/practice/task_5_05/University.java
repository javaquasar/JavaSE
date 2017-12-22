package core.lecture3_05_IO_Stream.practice.task_5_05;

import java.io.Serializable;

public class University implements Serializable {

	private static final long serialVersionUID = 2433147861334322335L;
	private String name;
	private String city;
	private double numberOfStudents;

	public University(String name, String city, double numberOfStudents) {
		this.name = name;
		this.city = city;
		this.numberOfStudents = numberOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(double numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}


}
