package core.lecture3_02_Collections.example;

import java.util.*;

public class Sentence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Функция nextLine() читает строку до конца:
		String sentence = scanner.nextLine();
		// Создаем множество разделителей:
		Set<Character> delimiters = new HashSet<Character>(Arrays.asList(' ', '.', ',', ':', ';', '?', '!', '-', '(', ')', '\"'));
		// Создаем множество букв:
		Set<Character> letters = new TreeSet<Character>();
		// Добавляем все буквы кроме разделителей:
		for (int i = 0; i < sentence.length(); i++) {
			if (!delimiters.contains(sentence.charAt(i)))
				letters.add(sentence.charAt(i));
		}
		System.out.println(letters);
	}

}
