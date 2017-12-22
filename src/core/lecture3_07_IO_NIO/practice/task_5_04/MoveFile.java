package core.lecture3_07_IO_NIO.practice.task_5_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFile {
	public static void main(String[] args) {
		Path pathSource = Paths.get("Вставьте сюда путь к файлу/директории, который надо переместить");
		Path pathDestination = Paths.get("Вставьте сюда путь для нового местоположения файла/директории");
		try {
			Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
