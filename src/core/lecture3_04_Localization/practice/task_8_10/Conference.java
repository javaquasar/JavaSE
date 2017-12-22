package core.lecture3_04_Localization.practice.task_8_10;

import java.util.ArrayList;

public class Conference {
	private ArrayList<Person> persons = new ArrayList<>();
	private String topic;
	private String city;

	public Conference(String topic, String city) {
		this.topic = topic;
		this.city = city;
	}

	public void add(Person person) {
		persons.add(person);
	}

	public void print() {
		if (persons.size() != 0) {
			System.out.println(topic);
			System.out.println(city);
			System.out.println("Участники:");
			for (Person person : persons) {
				System.out.println(person);
			}
		} else {
			System.out.println("Добавьте учатсников конференции!");
		}
	}
}
