package core.lecture3_05_IO_Stream.practice.task_5_04;

import java.io.*;

public class DataDeserialization {

	public static void main(String[] args) throws ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file/lecture_3_05_task_5_04_group.dat"))) {
			Group group = (Group) in.readObject();
			for (Student student : group.getStudents())
				System.out.println(student.getName() + " " + student.getLastname() + " " + student.getCours());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
