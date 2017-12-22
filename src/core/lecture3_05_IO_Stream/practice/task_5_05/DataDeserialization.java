package core.lecture3_05_IO_Stream.practice.task_5_05;

import java.io.*;

public class DataDeserialization {

	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/lecture_3_05_task_5_05_group_generic.dat"))) {
			Group<University> group = (Group<University>) in.readObject();
			for (University student : group.getStudents())
				System.out.println(student.getName() + " " + student.getCity() + " " + student.getNumberOfStudents());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
