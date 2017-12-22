package core.lecture3_05_IO_Stream.practice.task_5_03;

import java.io.*;
import java.util.Scanner;

/*5.3 Работа с несколькими файлами*

Разработать программу, которая осуществляет чтение из текстового 
файла целых чисел и сохранение в двух файлах данных (DataOutputStream) 
соответственно четных и нечетных чисел. В другой программе прочитать 
данные из двух файлов данных (DataInputStream) и записать их в новый 
текстовый файл в порядке убывания. Использовать PriorityQueue для 
обеспечения упорядоченности чисел.*/

public class FileTestEvenOrUneven {

	void readWrite() {
		double temp = 0;
		try (Scanner scanner = new Scanner(new FileReader("./file/lecture_3_05_task_5_03_read.txt"))) {
			try (PrintWriter pwEven = new PrintWriter("./file/lecture_3_05_task_5_03_even.txt"); PrintWriter pwUneven = new PrintWriter("lecture_3_05_task_5_03_uneven.txt")) {
				while (scanner.hasNext()) {
					temp = scanner.nextDouble();
					if (temp%2 == 0) {
						pwEven.println(temp);
					} else {
						pwUneven.println(temp);
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileTestEvenOrUneven().readWrite();
	}

}