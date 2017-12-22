package core.lecture2_06_Defining_classes.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Group {

	private List<Student> listOfStudent = new ArrayList<Student>();

	public static void main(String[] args) {
		Student student1 = new Student("Артур", "Бузов", 1990, "Харьков", "Подрабатывает");
		Student student2 = new Student("Павел", "Беличенко", 1993, "Харьков", "Занимался тайским боксом");
		Student student3 = new Student("Анастасия", "Бончук", 1991, "Харьков", "Увлекается музыкой. Инструмент - басгитара");
		Student student4 = new Student("Алексей", "Капустник", 1992, "Харьков", "Студент. Лазит по крышам. Играет на гитаре.");
		Student student5 = new Student("Виталий", "Карнаух", 1990, "Харьков", "Студент. Занимается самбо.");
		Student student6 = new Student("Кирил", "Кравчинский", 1980, "Харьков", "Работал в банке. Знает С++");
		Student student7 = new Student("Алексей", "Литвиненко", 1991, "Харьков", "Студент. Увлекается футболом.");
		Student student8 = new Student("Полина", "Хаинсон", 1987, "Харьков", "Увлекается музыкой. Инструменты: контрабас и пианино");
		Student student9 = new Student("Анастасия", "Пырлык", 1992, "Харьков", "Студентка");
		Student student10 = new Student("Чабан", "Олег", 1989, "Харьков", "Работал переводчиком");

		Group myGroup = new Group();
		myGroup.add(student1);
		myGroup.add(student2);
		myGroup.add(student3);
		myGroup.add(student4);
		myGroup.add(student5);
		myGroup.add(student6);
		myGroup.add(student7);
		myGroup.add(student8);
		myGroup.add(student9);
		myGroup.add(student10);

		System.out
				.println("Средний возраст группы " + myGroup.getAverageYear());
		System.out.println("Наименьший год рождения " + myGroup.getMinYear());
		System.out.println("Наибольший год рождения " + myGroup.getMaxYear());
		System.out.println("Самая длинная фамилия - "
				+ myGroup.getMaxLastName());
		System.out.println("Cтуденты с определенной буквой в имени \n"
				+ myGroup.getStudentWithLetterInName("а"));
		System.out.println("Cтуденты с определенной буквой в фамилии \n"
				+ myGroup.getStudentWithLetterInLastName("а"));
		System.out.println("Cтуденты с именами на указанную букву \n"
				+ myGroup.getStudentWithFirstLetterInName("а"));
		System.out.println("Студенты с фамилиями на указанную букву \n"
				+ myGroup.getStudentWithFirstLetterInLastName("б"));
		System.out.println("Студенты с определенным словом в комментарии \n"
				+ myGroup.getStudentWithWordInComment("Студент"));
		System.out.println("Cтудент с наибольшим количеством слов в комментарии \n"
				+ myGroup.getStudentWithMaxCountWordInComment());
	}

	public void add(Student student) {
		listOfStudent.add(student);
	}

	public int getAverageYear() {
		int temp = 0;
		for (Student student : listOfStudent) {
			temp += student.getYear();
		}
		return temp / listOfStudent.size();
	}

	public int getMinYear() {
		int temp = listOfStudent.get(0).getYear();
		int year = 0;
		for (Student student : listOfStudent) {
			year = student.getYear();
			if (temp > year) {
				temp = year;
			}
		}
		return temp;
	}

	public int getMaxYear() {
		int temp = listOfStudent.get(0).getYear();
		int year = 0;
		for (Student student : listOfStudent) {
			year = student.getYear();
			if (temp < year) {
				temp = year;
			}
		}
		return temp;
	}

	public String getMaxLastName() {
		int number = 0;
		int sizeLastName = 0;
		int temp = 0;
		for (int i = 0; i < listOfStudent.size(); i++) {
			sizeLastName = listOfStudent.get(i).getLastName().length();
			if (temp < sizeLastName) {
				temp = sizeLastName;
				number = i;
			}
		}
		return listOfStudent.get(number).getLastName();
	}

	public String getStudentWithLetterInName(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Student student : listOfStudent) {
			if (student.getName().contains(string)) {
				stringBuilder.append(student.getName() + " ");
				stringBuilder.append(student.getLastName() + " ");
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	
	public String getStudentWithLetterInLastName(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Student student : listOfStudent) {
			if (student.getLastName().contains(string)) {
				stringBuilder.append(student.getName() + " ");
				stringBuilder.append(student.getLastName() + " ");
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	
	public String getStudentWithFirstLetterInName(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		String tempChar;
		for (Student student : listOfStudent) {
			tempChar = "" + student.getName().charAt(0);
			if (tempChar.equalsIgnoreCase(string)) {	
				stringBuilder.append(student.getName() + " ");
				stringBuilder.append(student.getLastName() + " ");
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	
	public String getStudentWithFirstLetterInLastName(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		String tempChar;
		for (Student student : listOfStudent) {
			tempChar = "" + student.getLastName().charAt(0);
			if (tempChar.equalsIgnoreCase(string)) {
				stringBuilder.append(student.getLastName() + " ");
				stringBuilder.append(student.getName() + " ");
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	
	public String getStudentWithWordInComment(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Student student : listOfStudent) {
			if (student.getComment().contains(string)) {
				stringBuilder.append(student.getLastName() + " ");
				stringBuilder.append(student.getName() + " ");
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	
	public String getStudentWithMaxCountWordInComment() {
		int number = 0;
		int size = 0;
		int temp = 0;
		String[] words;
		for (int i = 0; i < listOfStudent.size(); i++) {
			words = listOfStudent.get(i).getComment().split("\\s+");
			size = words.length;
			if (temp < size) {
				temp = size;
				number = i;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(listOfStudent.get(number).getLastName() + " ");
		stringBuilder.append(listOfStudent.get(number).getName() + " ");
		stringBuilder.append("\n");
		
		return listOfStudent.get(number).getLastName();
	}
}
