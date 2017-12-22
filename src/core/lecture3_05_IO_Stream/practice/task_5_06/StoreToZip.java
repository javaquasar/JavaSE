package core.lecture3_05_IO_Stream.practice.task_5_06;

import java.io.*;
import java.util.zip.*;

import core.lecture3_05_IO_Stream.practice.task_5_04.Group;
import core.lecture3_05_IO_Stream.practice.task_5_04.Student;

public class StoreToZip {

	public static void main(String[] args) {

		Group group = new Group("АТР", new Student("Артур", "Бузов", "АТР", "курс 5"), new Student("Иван", "Бойко", "АТР", "курс 4"), new Student("Кирил", "Фейман", "АТР", "курс 3"));
		try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream("./file/lecture_3_05_task_5_06_group.zip")); DataOutputStream out = new DataOutputStream(zOut)) {
			for (Student student : group.getStudents()) {
				ZipEntry zipEntry = new ZipEntry(student.getLastname());
				zOut.putNextEntry(zipEntry);
				out.writeUTF(student.getName());
				out.writeUTF("\n");
				out.writeUTF(student.getGroup());
				out.writeUTF("\n");
				out.writeUTF(student.getCours());
				zOut.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}