package core.lecture3_06_XML.practice.task_5_04;

import java.io.*;

public class DataSerialization {

	public static void main(String[] args) {
		Group group = new Group("АТР", new Student("Аурур", "Бузов", "АТР", "5"), new Student("Иван", "Бойко", "АТР", "4"), new Student("Кирил", "Фейман", "АТР", "3"));
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file/lecture_3_06_task_5_04_data_serialization.dat"))) {
			out.writeObject(group);
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
