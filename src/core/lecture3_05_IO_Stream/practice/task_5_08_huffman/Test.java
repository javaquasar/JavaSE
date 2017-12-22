package core.lecture3_05_IO_Stream.practice.task_5_08_huffman;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		boolean work = true;
		System.out.println("Для сжатия файла введите \"c\"");
		System.out.println("Для распаковки файла введите \"x\"");
		String comand = null;
		while (work) {
			comand = scanner.nextLine();
			if (comand.equals("c") || comand.equals("x")) {
				work = false;
			} else {
				System.out.println("Неверная команда!");
			}
		}

		work = true;

		System.out.println("Введите имя файла!");
		String path = null;

		path = scanner.nextLine();

		String[] mas = { comand, path };
		while (work) {
			try {
				Main.main(mas);
				work = false;
				System.out.println("Операция прошла успешно!");
			} catch (IOException e) {
				System.out.println("Невернае имя файла!");
			}
		}
	}
}
