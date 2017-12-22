package core.lecture3_04_Localization.practice.task_8_07_2;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class AbstractStudent {
	
	abstract public Student getStudent(int i);
	abstract public void setStudent(int i, Student s);
	abstract public int studentsCount();
	abstract public void addStudent(Student s);
	abstract public void clearStudent();
	abstract public void sortSurnamesByAlphabet();	
	abstract public void sortYearDown();
    abstract public List<Student> findStudentsBySurname(String regex);

		
	public void printAll() {
		for (int i = 0; i < studentsCount(); i++) {
		    System.out.println(getStudent(i).getName() + " " + getStudent(i).getSurname() + ", "
		          + getStudent(i).getYear() + ".");
		}
		    System.out.println();
	}
		
	class CompareBySurname implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
            Collator collator = Collator.getInstance(new Locale("uk"));
            return collator.compare(s1.getSurname(),s2.getSurname());
		}
	}

	class CompareByYear implements Comparator<Student> {
		public int compare(Student c1, Student c2) {
            return -Double.compare(c1.getYear(), c2.getYear());
		}
	}

}
