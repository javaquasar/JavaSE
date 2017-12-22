package core.lecture3_04_Localization.practice.task_8_07_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentList extends AbstractStudent {

	private List<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {

		AbstractStudent list = new StudentList();
		list.addStudent(new Student("Артур", "Бузов", 1990));
		list.addStudent(new Student("Виталий", "Іванов", 1994));
		list.addStudent(new Student("Олег", "Коновалов", 1991));
		list.addStudent(new Student("Кирил", "Їтест", 1989));
		System.out.println("------------------");
		list.sortYearDown();
		list.printAll();
		System.out.println("------------------");
		list.sortSurnamesByAlphabet();
		list.printAll();

	}

	@Override
	public Student getStudent(int i) {
		return students.get(i);
	}

	@Override
	public void setStudent(int i, Student student) {
		students.set(i, student);
	}

	@Override
	public int studentsCount() {
		return students.size();
	}

	@Override
	public void addStudent(Student student) {
		students.add(student);
	}

	@Override
	public void clearStudent() {
		students = null;
	}

	@Override
	public void sortSurnamesByAlphabet() {
		Collections.sort(students, new CompareBySurname());
	}

	@Override
	public void sortYearDown() {
		Collections.sort(students, new CompareByYear());
	}

	@Override
	public List<Student> findStudentsBySurname(String regex) {
		Pattern pattern = Pattern.compile(regex);
		List<Student> result = null;
		students.forEach(a -> {
			Matcher matcher = pattern.matcher(a.getSurname());
			if (matcher.matches()) {
				result.add(a);
			}
		});
		return result;
	}
}
