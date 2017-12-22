package core.lecture2_02_Syntax.practice;

import java.util.Scanner;

public class SwitchTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите n >= 0.");
		int n = scanner.nextInt();
		int y;
		switch (n) {
		case 0:
			y = 2;
			break;
		case 1:
			y = 4;
			break;
		case 2:
			y = 5;
			break;
		case 3:
			y = 3;
			break;
		case 4:
			y = 1;
			break;
		default:
			y = 0;
		}
		System.out.println(y);
	}

}
