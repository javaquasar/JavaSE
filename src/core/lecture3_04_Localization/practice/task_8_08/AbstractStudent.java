package core.lecture3_04_Localization.practice.task_8_08;

import java.util.Comparator;

abstract public class AbstractStudent {
	
	abstract public Student getStudent(int i);
	abstract public void setStudent(int i, Student s);
	abstract public int studentsCount();
	abstract public void addStudent(Student s);
	abstract public void clearStudent();
	abstract public void sortSurnamesByAlphabet();	
	abstract public void sortYearDown();
		
	public void printAll() {
		System.out.println("�������� ������ ����-14-1\n");
		for (int i = 0; i < studentsCount(); i++) {
		    System.out.println(getStudent(i).getName() + " " + getStudent(i).getSurname() + ", "
		          + getStudent(i).getYear() + "�.");
		}
		    System.out.println();
	}
		
	class CompareBySurname implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			 return s1.getSurname().compareTo(s2.getSurname());
		}
	}

	class CompareByYear implements Comparator<Student> {
		public int compare(Student c1, Student c2) {
			return -Double.compare(c1.getYear(), c2.getYear());
		}
	}
		
	public void test() {
		addStudent(new Student("��������", "��������", 1993));
		addStudent(new Student("���������", "������", 1993));
		addStudent(new Student("�����", "��������", 1992));
		addStudent(new Student("���������", "�����", 1994));
		sortSurnamesByAlphabet();
		printAll();
		System.out.println("------------------");
		sortYearDown();
		printAll();
	}
}
