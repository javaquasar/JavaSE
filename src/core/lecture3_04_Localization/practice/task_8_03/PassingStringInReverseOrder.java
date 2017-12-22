package core.lecture3_04_Localization.practice.task_8_03;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

/*8.3 Прохождение строки в обратном порядке*

Осуществить с помощью итератора прохождение 
строки от заданного индекса к началу строки.*/

public class PassingStringInReverseOrder {

	private static final String text = "Jackdaws love my big sphinx of quartz";
	private static Scanner scanner;
	private static String string;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		string = scanner.nextLine();
		
		CharacterIterator it = new StringCharacterIterator(string);
		for (char ch = it.last(); ch != CharacterIterator.DONE; ch = it.previous()) {
			System.out.print(ch);
		}
	}

}
