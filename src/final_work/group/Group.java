package final_work.group;

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
import java.util.regex.Pattern;

import final_work.group.Person;

public class Group implements Serializable {

	private static final long serialVersionUID = 4433147861334322335L;
	private String name;
	private ArrayList<Person> persons = new ArrayList<>();

	public static void main(String[] args) {

		Group list = new Group();
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бондалетова", "Кристина", "Валериевна", 1990, 6, 7, "+38 (050) 229-76-39", "kristina.bondaletova@gmail.com", "bon-kristi"));
		list.addPerson(new Person("Михайловский", "Владислав", "Анатолиевич", 1997, 8, 12, "+38 (050) 210-84-84", "westblackjoe246@gmail.com", "black_joe321"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Бузов", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));
		list.addPerson(new Person("Їтест", "Артур", "Валериевич", 1990, 8, 4, "+38 (050) 521-71-32", "buzov.artur@gmail.com", "buzow.artur"));

		System.out.println("------------------");
		// list.sortYearDown();
		list.printAll();
		System.out.println("------------------");
		// list.sortSurnamesByAlphabet();
		list.sort(TypeSort.LAST_NAME);
		list.printAll();
		list.serialization("./file/lecture_3_09_task_5_08_XML_serialization.xml");

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

	public Person getPerson(int i) {
		return persons.get(i);
	}

	public void setPerson(int i, Person person) {
		persons.set(i, person);
	}

	public int personsCount() {
		return persons.size();
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void clearStudent() {
		persons = null;
	}

	public void sort(TypeSort typeSort) {
		switch (typeSort) {
		case LAST_NAME:
			Collections.sort(persons, new CompareByLastname());
			break;
		case NAME:
			Collections.sort(persons, new CompareByName());
			break;
		case BIRTHDAY:
			Collections.sort(persons, new CompareByYear());
			break;
		case PHONE:
			Collections.sort(persons, new CompareByLastname());
			break;
		case EMAIL:
			Collections.sort(persons, new CompareByLastname());
			break;
		case SKYPE:
			Collections.sort(persons, new CompareByLastname());
			break;
		default:
			break;
		}
	}

	public void sortSurnamesByAlphabet() {
		Collections.sort(persons, new CompareByLastname());
	}

	public void sortNamesByAlphabet() {
		Collections.sort(persons, new CompareByName());
	}

	public void sortYearDown() {
		Collections.sort(persons, new CompareByYear());
	}

	public List<Person> findStudentsBySurname(String regex) {
		Pattern pattern = Pattern.compile(regex);
		List<Person> result = new ArrayList<>();
		/*
		 * students.forEach(a -> { Matcher matcher =
		 * pattern.matcher(a.getSurname()); if (matcher.matches()) {
		 * result.add(a); } });
		 */
		for (Person person : persons) {
			if (person.getLastname().toLowerCase().contains(regex.toLowerCase())) {
				result.add(person);
			}
		}
		return result;
	}

	public String findStudentsString(String regex) {
		StringBuilder stringBuilder = new StringBuilder();
		List<Person> list = findStudentsBySurname(regex);
		if (list.size() == 0) {
			return null;
		}

		for (Person person : list) {
			stringBuilder.append(person.getLastname());
			stringBuilder.append(" ");
			stringBuilder.append(person.getName());
			stringBuilder.append(" ");
			stringBuilder.append(person.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setStudents(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public void serialization(String path) {
		// "./file/lecture_3_09_task_5_08_XML_serialization.xml"
		try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(path))) {
			xmlEncoder.writeObject(this);
			xmlEncoder.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Group deserialization(String path) {
		// "./file/lecture_3_09_task_5_08_XML_serialization.xml"
		Group group = null;
		try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(path))) {
			group = (Group) xmlDecoder.readObject();
			/*
			 * for (Student student : group.getStudents()) {
			 * System.out.println(student.getName() + " " +
			 * student.getLastname() + " " + student.getCours()); }
			 */
			return group;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return group;
	}

	public void printAll() {
		for (int i = 0; i < personsCount(); i++) {
			System.out.println(getPerson(i).getName() + " " + getPerson(i).getLastname() + ", " + getPerson(i).getYear() + ".");
		}
		System.out.println();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Person person : persons) {
			stringBuilder.append(person.getLastname());
			stringBuilder.append(" ");
			stringBuilder.append(person.getName());
			stringBuilder.append(" ");
			stringBuilder.append(person.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public String toStringYear() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Person person : persons) {
			stringBuilder.append(person.getYear());
			stringBuilder.append(" ");
			stringBuilder.append(person.getLastname());
			stringBuilder.append(" ");
			stringBuilder.append(person.getName());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public String toStringName() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Person person : persons) {
			stringBuilder.append(person.getName());
			stringBuilder.append(" ");
			stringBuilder.append(person.getLastname());
			stringBuilder.append(" ");
			stringBuilder.append(person.getYear());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	class CompareByLastname implements Comparator<Person> {
		public int compare(Person s1, Person s2) {
			Collator collator = Collator.getInstance(new Locale("uk"));
			return collator.compare(s1.getLastname(), s2.getLastname());
		}
	}

	class CompareByName implements Comparator<Person> {
		public int compare(Person s1, Person s2) {
			Collator collator = Collator.getInstance(new Locale("uk"));
			return collator.compare(s1.getName(), s2.getName());
		}
	}

	class CompareByYear implements Comparator<Person> {
		public int compare(Person c1, Person c2) {
			return -Double.compare(c1.getYear(), c2.getYear());
		}
	}

}
