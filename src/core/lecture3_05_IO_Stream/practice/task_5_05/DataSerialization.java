package core.lecture3_05_IO_Stream.practice.task_5_05;

import java.io.*;

public class DataSerialization {

	public static void main(String[] args) {
		Group<University> group = new Group<>("АТР", new University("ХАИ", "Харьков", 25000), new University("ДПИ", "Донецк", 30000), new University("ХАДИ", "Харьков", 8000));
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/lecture_3_05_task_5_05_group_generic.dat"))) {
			out.writeObject(group);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
