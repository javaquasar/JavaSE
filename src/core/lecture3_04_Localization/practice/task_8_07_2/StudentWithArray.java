package core.lecture3_04_Localization.practice.task_8_07_2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentWithArray extends AbstractStudent{
	private Student [] students = {}; 
	
    public static void main(String [] args) {
    	AbstractStudent list = new StudentWithArray();
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
	    return students[i];
	}

	@Override
	public void setStudent(int i, Student student) {
	    students[i] = student;
	}

	@Override
	public int studentsCount() {
		return students == null ? 0 : students.length;
	}

	@Override
	public void addStudent(Student s) {
		Student[] temp = new Student[studentsCount() + 1]; 
		if (students != null) {
		   System.arraycopy(students, 0, temp, 0, students.length);
		}
		temp[studentsCount()] = s;
		students = temp;
	}
	
	@Override
	public void clearStudent() {
		students = null;
	}
	
	@Override
	public void sortSurnamesByAlphabet() {
		Arrays.sort(students, new CompareBySurname());
	}

	@Override
	public void sortYearDown() {
		Arrays.sort(students, new CompareByYear());
	}

    @Override
    public List<Student> findStudentsBySurname(String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<Student> result = null;
        for (Student student : students) {
            Matcher matcher = pattern.matcher(student.getSurname());
            if(matcher.matches()){
                result.add(student);
            }
        }
        return result;
    }

}
