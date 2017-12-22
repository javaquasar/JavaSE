package core.lecture2_07_OOP.practice.task_9_01_hierarchy;

public class PermanentEmployee extends Employee {

	private double wage;
	private double premium;
	private double sallary;

	public PermanentEmployee(String name, String surName, int age,
			String registration, double wage, double premium) {
		super(name, surName, age, registration);
		this.wage = wage;
		this.premium = premium;
	}

	void payroll() {
		setSallary(wage + (wage * (premium / 100)));
	}

	public double getSallary() {
		return sallary;
	}

	private void setSallary(double sallary) {
		this.sallary = sallary;
	}

	@Override
	public String toString() {
		return "Сотрудник на ставке, имя: " + name + ", фамилия: " + surName
				+ ", возраст: " + age + ", прописка: " + registration
				+ ", ставка: " + wage + ", премия: " + premium + "%";
	}

}
