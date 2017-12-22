package core.lecture3.control.number_3;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		try {
			LoaderForClass loaderForClass = LoaderForClass.getInstance("../Nix2/bin/", "toInit");
			loaderForClass.start();
			System.out.println("Для прекращения работы нажмите Enter!");
			String s = scanner.nextLine();
			//loaderForClass.stop();
			loaderForClass.interrupt();
			System.out.println("Конец");
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
