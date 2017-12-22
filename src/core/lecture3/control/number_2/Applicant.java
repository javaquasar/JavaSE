package core.lecture3.control.number_2;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Applicant implements java.io.Serializable {

	private static final long serialVersionUID = -3536722853756147165L;
	private String name;
	private String lastname;
	// private LocalDate dateOfBirthday;
	private String email;
	private HashSet<String> programmingLanguages;

	private int year;
	private int month;
	private int day;

	public Applicant() {

	}

	public Applicant(String name, String lastname, int year, int month,
			int day, String email, HashSet<String> programmingLanguages) {
		this.name = name;
		this.lastname = lastname;
		// this.dateOfBirthday = LocalDate.of(2015, 3, 8);
		this.email = email;
		this.programmingLanguages = programmingLanguages;
		this.year = year;
		this.month = month;
		this.day = day;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public HashSet<String> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(HashSet<String> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	public String genLanguages() {
		StringBuilder stringBuilder = new StringBuilder();
		for(String s : programmingLanguages) {
			stringBuilder.append(s);
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getLastname());
		stringBuilder.append(" ");
		stringBuilder.append(getName());
		stringBuilder.append(". День рождения - ");
		stringBuilder.append(getLocalDate());
		stringBuilder.append(". Email - ");
		stringBuilder.append(getEmail());
		stringBuilder.append(". Языки програмирования: ");
		stringBuilder.append(genLanguages());
		stringBuilder.append("\r\n");
		return stringBuilder.toString();
	}

	public LocalDate getLocalDate() {
		return LocalDate.of(year, month, day);
	}

}
