package core.lecture3_05_IO_Stream.practice.task_5_03_2;


import java.io.*;
import java.util.*;

public class IntReader {

	public static void main(String[] args) {
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();
		try(Scanner scanner = new Scanner(new FileReader("./file/lecture_3_05_task_5_03_read.txt"))){
			try {
				while (true) {
					int x = scanner.nextInt();
					if (x % 2 == 0) {
						even.add(x);
					} else {
						odd.add(x);
					}
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"./file/lecture_3_05_task_5_03_even.dat"))) {
			for (Integer x : even) {
				out.writeInt(x);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"./file/lecture_3_05_task_5_03_uneven.dat"))) {
			for (Integer y : odd) {
				out.writeInt(y);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
