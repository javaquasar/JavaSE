package core.lecture3_05_IO_Stream.practice.task_5_06;

import java.io.*;
import java.util.zip.*;

public class ReadFromZip {

	public static void main(String[] args) {
		try (ZipInputStream zIn = new ZipInputStream(new FileInputStream("./file/lecture_3_05_task_5_06_group.zip")); DataInputStream in = new DataInputStream(zIn)) {
			ZipEntry entry;
			while ((entry = zIn.getNextEntry()) != null) {
				System.out.println("Фамилия: " + entry.getName());
				System.out.println("Имя: " + in.readUTF());
				in.readUTF();
				System.out.println("Группа: " + in.readUTF());
				in.readUTF();
				System.out.println("Курс: " + in.readUTF());
				System.out.println();
				zIn.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}