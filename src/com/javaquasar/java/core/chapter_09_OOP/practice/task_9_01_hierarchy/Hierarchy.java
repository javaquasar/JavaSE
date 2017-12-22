package com.javaquasar.java.core.chapter_09_OOP.practice.task_9_01_hierarchy;

public class Hierarchy {
	public static void main(String[] args) {
		testObjReferences();
		Employee[] emp = createEmployees();
		for (Employee x : emp) {
			System.out.println(x);
		}
		System.out.println();
		payAll(emp);
		showSallaries(emp);
	}

	private static void showSallaries(Employee[] emp) {
		for (Employee x : emp) {
			System.out.println(x.getName() + " " + x.getSurName()
					+ " заработал: " + x.getSallary());
		}
	}

	private static void payAll(Employee[] emp) {
		for (Employee x : emp) {
			x.payroll();
		}
	}

	private static Employee[] createEmployees() {
		Employee[] emp = {
				new EmployeePaidByTheHour("Олег", "Чабан", 26, "г.Харьков", 30,
						100),
				new EmployeePaidByTheHour("Артур", "Бузов", 24, "г.Харьков",
						45, 300),
				new PermanentEmployee("Павел", "Беличенко", 20, "г.Харьков",
						6000, 15),
				new PermanentEmployee("Алексей", "Капустник", 27, "г.Харьков",
						8000, 20),
				new PermanentEmployee("Виталий", "Карнаух", 23, "г.Харьков",
						8000, 10) };
		return emp;
	}

	public static void testObjReferences() {
		Object[] obj = {
				new Human("Артур", "Бузов", 26),
				new Citizen("Павел", "Беличенко", 28, "г.Харьков"),
				new EmployeePaidByTheHour("Алексей", "Капустник", 23, "г.Харьков",
						30, 250),
				new PermanentEmployee("Великоцкий", "Александр", 26,
						"г.Харьков", 6000, 20),
				new PermanentEmployee("Виталий", "Карнаух", 25, "г.Харьков", 8000,
						20), new Citizen("Олег", "Чабан", 24, "г.Донецк") };
		for (Object x : obj) {
			System.out.println(x);
		}
	}
}

