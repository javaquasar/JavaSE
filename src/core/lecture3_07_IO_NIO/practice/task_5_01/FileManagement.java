package core.lecture3_07_IO_NIO.practice.task_5_01;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManagement {

	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		File file = new File(dir+"\\test.txt");
		file.createNewFile(); //создаем файл
		System.out.println(Arrays.asList(dir.list())); //получаем имена папок и файлов в текущей директории
		file.delete(); //удаляем файл
		
	}
}
