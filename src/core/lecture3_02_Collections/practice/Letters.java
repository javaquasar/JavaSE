package core.lecture3_02_Collections.practice;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/*6.6 Определение частоты вхождения букв*

Ввести предложение и вывести все различные буквы, входящие в предложение и 
количество их вхождения. Использовать ассоциативный массив.*/

public class Letters {

	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.print("Введите строку из слов -> ");
		scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		SortedMap<Character, Integer> letters = new TreeMap<>();

		int temp = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(!letters.containsKey(s.charAt(i))) {
				letters.put(s.charAt(i), 1);
			} else {
				temp = letters.get(s.charAt(i));
				letters.put(s.charAt(i), ++temp);
			}
		}

		for (Map.Entry<?, ?> letter : letters.entrySet()) {
			System.out.println(letter.getKey() + " " + letter.getValue());
		}
	}

}
