package core.lecture2_07_OOP.practice.task_9_01_hierarchy;

public class EmployeePaidByTheHour extends Employee {

	private double hourlyPay;
	private double hoursWorked;
	private double sallary;

	public EmployeePaidByTheHour(String name, String surName, int age,
			String registration, double hourlyPay, double hoursWorked) {
		super(name, surName, age, registration);
		this.hourlyPay = hourlyPay;
		this.hoursWorked = hoursWorked;
	}

	void payroll() {
		setSallary(hourlyPay * hoursWorked);
	}

	public double getSallary() {
		return sallary;
	}

	private void setSallary(double sallary) {
		this.sallary = sallary;
	}

	@Override
	public String toString() {
		return "Сотрудник с почасовой оплатой, имя: " + name + ", фамилия: "
				+ surName + ", возраст: " + age + ", прописка: " + registration
				+ ", часовая оплата: " + hourlyPay + ", отработано часов: "
				+ hoursWorked;
	}

}

