package core.lecture2_07_OOP.practice.task_9_01_hierarchy;

public class Citizen extends Human{
	String registration;

	public Citizen(String name, String surName, int age, String registration) {
		super(name, surName, age);
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "Гражданин, имя: " + name + ", фамилия: " + surName
				+ ", возраст: " + age + ", прописка: " + registration;
	}
}
