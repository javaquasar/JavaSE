package core.lecture3_09_Swing.practice.task_5_08.group;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Group implements Serializable {

	private static final long serialVersionUID = 4433147861334322335L;
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {

		Group list = new Group();
		list.addStudent(new Student("Артур", "Бузов", 1990));
		list.addStudent(new Student("Виталий", "Іванов", 1994));
		list.addStudent(new Student("Олег", "Коновалов", 1991));
		list.addStudent(new Student("Кристина", "Бондалетова", 1989));
		list.addStudent(new Student("Виталий", "Гончар", 1979));
		list.addStudent(new Student("Евгений", "Пехуля", 1995));
		list.addStudent(new Student("Диана", "Баленко", 1990));
		list.addStudent(new Student("Анастасия", "Ваарметс", 1991));
		list.addStudent(new Student("Павел", "Вайсер", 2000));
		list.addStudent(new Student("Виталий", "Карнаух", 1988));
		list.addStudent(new Student("Юрий", "Беженцев", 1987));
		list.addStudent(new Student("Владислав", "Высоцкий", 1989));
		list.addStudent(new Student("Светлана", "Крыжний", 1989));
		list.addStudent(new Student("Олег", "Савченко", 1960));
		list.addStudent(new Student("Артур", "Плуум", 1997));
		list.addStudent(new Student("Кирил", "Їтест", 1989));
		
		System.out.println("------------------");
		//list.sortYearDown();
		list.printAll();
		System.out.println("------------------");
		//list.sortSurnamesByAlphabet();
		list.printAll();
		list.serialization("./lecture_3_09_task_5_08_XML_serialization.xml");

	}
	
	
	public Group() {
		// для сериализации в XML обязательно нужен конструктор без параметров
	}
	
	public Group(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent(int i) {
		return students.get(i);
	}

	public void setStudent(int i, Student student) {
		students.set(i, student);
	}

	public int studentsCount() {
		return students.size();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void clearStudent() {
		students = null;
	}

	public void sortSurnamesByAlphabet() {
		Collections.sort(students, new CompareBySurname());
	}
	
	public void sortNamesByAlphabet() {
		Collections.sort(students, new CompareByName());
	}

	public void sortYearDown() {
		Collections.sort(students, new CompareByYear());
	}

	public List<Student> findStudentsBySurname(String regex) {
		Pattern pattern = Pattern.compile(regex);
		List<Student> result = new ArrayList<>();
		/*students.forEach(a -> {
			Matcher matcher = pattern.matcher(a.getSurname());
			if (matcher.matches()) {
				result.add(a);
			}
		});*/
		for(Student student : students) {
			if (student.getSurname().toLowerCase().contains(regex.toLowerCase())) {
				result.add(student);
			}
		}
		return result;
	}
	
	public String findStudentsString(String regex) {
		StringBuilder stringBuilder = new StringBuilder();
		List<Student> list = findStudentsBySurname(regex);
		if (list.size() == 0) {
			return null;
		}
		
		for(Student student : list) {
			stringBuilder.append(student.getSurname());
			stringBuilder.append(" ");
			stringBuilder.append(student.getName());
			stringBuilder.append(" ");
			stringBuilder.append(student.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}


	public ArrayList<Student> getStudents() {
		return students;
	}


	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public void serialization(String path) {
    	//"./file/lecture_3_09_task_5_08_XML_serialization.xml"
		try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(path))) {
			xmlEncoder.writeObject(this);
			xmlEncoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public static Group deserialization(String path) {
    	//"./file/lecture_3_09_task_5_08_XML_serialization.xml" 
		Group group = null;
		try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(path))) {
			group = (Group)  xmlDecoder.readObject();
			/*for (Student student : group.getStudents()) {
				System.out.println(student.getName() + " " + student.getLastname() + " " + student.getCours());
			}*/
			return group;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return group;
	}

		
	public void printAll() {
		for (int i = 0; i < studentsCount(); i++) {
		    System.out.println(getStudent(i).getName() + " " + getStudent(i).getSurname() + ", "
		          + getStudent(i).getYear() + ".");
		}
		    System.out.println();
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Student student : students) {
			stringBuilder.append(student.getSurname());
			stringBuilder.append(" ");
			stringBuilder.append(student.getName());
			stringBuilder.append(" ");
			stringBuilder.append(student.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	public String toStringYear() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Student student : students) {
			stringBuilder.append(student.getYear());
			stringBuilder.append(" ");
			stringBuilder.append(student.getSurname());
			stringBuilder.append(" ");
			stringBuilder.append(student.getName());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	public String toStringName() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Student student : students) {
			stringBuilder.append(student.getName());
			stringBuilder.append(" ");
			stringBuilder.append(student.getSurname());
			stringBuilder.append(" ");
			stringBuilder.append(student.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
		
	class CompareBySurname implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
            Collator collator = Collator.getInstance(new Locale("uk"));
            return collator.compare(s1.getSurname(),s2.getSurname());
		}
	}
	
	class CompareByName implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
            Collator collator = Collator.getInstance(new Locale("uk"));
            return collator.compare(s1.getName(),s2.getName());
		}
	}

	class CompareByYear implements Comparator<Student> {
		public int compare(Student c1, Student c2) {
            return -Double.compare(c1.getYear(), c2.getYear());
		}
	}

}
