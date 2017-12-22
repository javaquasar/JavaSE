package core.lecture3_04_Localization.practice.task_8_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentList extends AbstractStudent{
	
	private List<Student> students = new ArrayList<Student>(); 
	
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
	
	public static void main(String [] args) {
		new StudentWithArray().test();
	}
}

