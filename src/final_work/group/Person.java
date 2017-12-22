package final_work.group;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
	private String lastname = null;
	private String name = null;
	private String patronymic = null;
	private Calendar birthday = null;
	private String phone = null;
	private String email = null;
	private String skype = null;
	
	public Person(String lastname, String name, String patronymic, int year, int month, int day, String phone, String email, String skype) {
		this.lastname = lastname;
		this.name = name;
		this.patronymic = patronymic;
		this.birthday = new GregorianCalendar(year, month, day);
		this.phone = phone;
		this.email = email;
		this.skype = skype;
	}

	public static void main (String[] args) {
		//Date date = new Date(1990, 8, 4);
		Calendar c = new GregorianCalendar(2013, 11, 25);
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}
	
	public int getYear() {
		return birthday.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return birthday.get(Calendar.MONTH);
	}
	
	public int getDay() {
		return birthday.get(Calendar.DAY_OF_MONTH);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public static Integer calculateAge(final Date birthday)
	{
		Calendar dob = Calendar.getInstance();
		Calendar today = Calendar.getInstance();

		dob.setTime(birthday);
		// include day of birth
		dob.add(Calendar.DAY_OF_MONTH, -1);

		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
}
