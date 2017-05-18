package com.javaquasar.java.core.chapter_03_String.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class WorkWithfString {

	private static Scanner scanner;
	private static String string;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int number = 7;
		switch (number) {
		case 3:
			System.out.println("Задание 4.3 - Удаление слов");

			System.out.print("Введите строку -> ");
			string = scanner.nextLine();
			// System.out.println(); System.out.print("Введите выражение -> ");
			String part = scanner.nextLine();
			System.out.println(deleteWord(string, part));
			break;
		case 4:
			System.out.println("Задание 4.4 - Символы по алфавиту без цифр");
			System.out.print("Введите строку -> ");
			string = scanner.nextLine();
			System.out.println(sortChar(string));
			break;
		case 5:
			System.out.println("Задание 4.5 - Аббревиатура");
			System.out.print("Введите строку -> ");
			string = scanner.nextLine();
			System.out.println(getAcronym(string));
			break;
		case 6:
			System.out.println("Задание 4.6 - Корректор");
			System.out.print("Введите строку -> ");
			string = scanner.nextLine();
			System.out.println(correct(string));
			break;
		case 7:
			System.out.println("Задание 4.7 - Форматированный вывод текста");
			System.out.print("Введите строку -> ");
			string = "123456789 123456789 1234567890 1234567890 12 345 34567 55678 334343 12 34 45 56 34 32 234556"
					+ "123456789 123456789 1234567890 1234567890 12 345 34567 55678 334343 12 34 45 56 34 32 234556";// scanner.nextLine();
			System.out.println(formatInWidth(string, 50));
			break;
		case 8:
			System.out.println("Задание 4.8 - Транслятор");
			System.out.print("Введите строку -> ");
			string = scanner.nextLine();
			System.out.println(translate(string));
			break;
		case 9:
			break;
		default:
		}

	}

	// удаляет слова содержащие последовательность символов part
	public static String deleteWord(String string, String part) {
		// StringBuilder stringBuilder = new StringBuilder();
		String myString = string;
		String[] words = string.split("\\s+");
		for (String word : words) {
			if (word.contains(part)) {
				// stringBuilder.append(word + " ");
				myString = myString.replaceAll(word, "");
			}
		}
		return myString;// stringBuilder.toString();
	}

	// сортирет символы в строке и удаляет все цыфры
	public static String sortChar(String string) {
		char[] chars = string.toCharArray();
		Arrays.sort(chars);
		StringBuilder stringBuilder = new StringBuilder();
		for (char myChar : chars) {
			if (!Character.isDigit(myChar)) {
				stringBuilder.append(myChar);
			}
		}
		return stringBuilder.toString();
	}

	// возвращает абревиатуру
	public static String getAcronym(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] words = string.split("\\s+");
		for (String word : words) {
			stringBuilder.append(word.charAt(0));
		}
		return stringBuilder.toString().toUpperCase();
	}

	// корректор
	public static String correct(String string) {
		String[] wordArray = string.split("\\s");

		StringBuilder sb = new StringBuilder();
		char ch = 0;
		char firstChar = 0;
		int endOfWord = 0;
		int endOfArray = wordArray.length;
		for (int i = 0; i < endOfArray; i++) {

			endOfWord = wordArray[i].length();
			for (int j = 0; j < endOfWord; j++) {
				ch = wordArray[i].charAt(j);
				if ((i == endOfArray - 1) && (j == endOfWord - 1)
						&& (ch != '.')) {
					sb.append(ch + ".");
				} else if ((j == endOfWord - 1) && (i < wordArray.length - 1)
						&& (ch != '.')) {
					firstChar = wordArray[i + 1].charAt(0);
					if (Character.isUpperCase(firstChar)) {
						sb.append(ch + ".");
					} else {
						sb.append(ch);
					}
				} else if ((j > 0) && (Character.isUpperCase(ch))) {
					sb.append(Character.toLowerCase(ch));
				} else {
					sb.append(ch);
				}
			}
			sb.append(" ");
		}

		String result = sb.toString();// .replaceAll(" .", ".");
		String[] words = result.split("\\s");

		for (String word : words) {
			if ((word.charAt(0) == 'ь') || (word.charAt(0) == 'Ь')) {
				System.out.println(word);
			}
		}
		return result;
	}
	
	// форматирует по ширине текст
		public static String formatInWidthNew(String string, int width) {
			
			return string;	
		}

	// форматирует по ширине текст
	public static String formatInWidth(String string, int width) {
		String[] words = string.split("\\s+");
		List<Integer> counutWords = new ArrayList<>();
		List<Integer> widthWords = new ArrayList<>();
		StringBuilder stringBuilder = new StringBuilder();
		int rest = 0;
		int myWidth = 0;
		int myWidthSpace = 0;
		int myWidthTotal = 0;
		int count = 0;
		int countTotal = 0;

		for (int i = 0; i < words.length; i++) {
			// получаем длину слов без пробелов
			myWidth += words[i].length();
			// количество слов в строке
			count++;
			// длина строки хотябы по одному пробелу между словами
			myWidthSpace = myWidth + (count - 1);
			rest++;
			// System.out.println("myWidthSpace" + myWidthSpace);
			if (myWidthSpace < width) {
				countTotal++; // число слов в строке окончательное
				myWidthTotal += words[i].length(); // длина слов без пробелов
				
			}
			if (myWidthSpace > width) {
				// System.out.println("myWidthTotal в условии " + myWidthTotal);
				// System.out.println("myWidthSpace в условии " + myWidthSpace);
				widthWords.add(myWidthTotal);
				counutWords.add(countTotal);
				myWidth = words[i].length();
				myWidthTotal = words[i].length();
				count = 1;
				countTotal = 1;
				myWidthSpace = myWidth + (count - 1);
				rest=0;
			}
			
		}
		System.out.println("rest" + rest);
		
		count = 0;
		myWidthTotal = 0;
		for (int i = words.length - (rest+1); i < words.length; i++) {
			count++;
			myWidthTotal += words[i].length();;
		}
		widthWords.add(myWidthTotal);//words[words.length - 1].length());
		counutWords.add(count);
		//System.out.println("counutWords = " + counutWords);
		//System.out.println("widthWords = " + widthWords);
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println("");
		int spase = 0;
		int spaseEnd = 0;
		count = 0;
		int countIn = 1;
		for (int i = 0; i < counutWords.size(); i++) {
			if (counutWords.get(i) > 2) {
				spase = (width - widthWords.get(i)) / (counutWords.get(i) - 1);
				spaseEnd = width - widthWords.get(i) - (counutWords.get(i) - 2)
						* spase;
				for (int j = 0; j < counutWords.get(i); j++) {
					stringBuilder.append(words[count]);
					if (countIn < counutWords.get(i) - 1) {
						for (int k = 0; k < spase; k++) {
							stringBuilder.append(" ");
						}
					} else if (countIn == (counutWords.get(i) - 1)) {
						for (int k = 0; k < spaseEnd; k++) {
							stringBuilder.append(" ");
						}
					}
					count++;
					countIn++;
				}
				countIn = 1;
				stringBuilder.append("\n");
			} else if (counutWords.get(i) == 2) {
				spase = width - widthWords.get(i);
				for (int j = 0; j < counutWords.get(i); j++) {
					stringBuilder.append(words[count]);
					for (int k = 0; k < spase; k++) {
						stringBuilder.append(" ");
					}
					count++;
				}
				stringBuilder.append("\n");
			} else if ((counutWords.get(i) == 1) && (widthWords.get(i) < width)) {

				spase = width - widthWords.get(i);
				stringBuilder.append(words[count]);
				for (int k = 0; k < spase; k++) {
					stringBuilder.append(" ");
				}
				stringBuilder.append("\n");
				count++;
			}
			// System.out.println("spase" + spase);
			// System.out.println("spaseEnd" + spaseEnd);
		}

		return stringBuilder.toString();

	}

	// транслятор
	public static String translate(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		int counter = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '{') {
				counter++;
				stringBuilder.append("(begin)");
			} else if (string.charAt(i) == '}') {
				counter--;
				stringBuilder.append("(end)");
				if (counter < 0) {
					return null;
				}
			} else {
				stringBuilder.append(string.charAt(i));
			}
		}

		if (counter == 0) {
			return stringBuilder.toString();
		} else if (counter > 0) {
			return null;
		} else {
			return null;
		}
	}

	// квадратный корень метод Ньютона
	public static Double getSquareRoot(Double number) {
		return number;
	}

	public static ArrayList<String> fix(ArrayList<String> list) {
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("р") && list.get(i).contains("л")) {
				tmp.add(list.get(i));
			} else if (list.get(i).contains("л")) {
				tmp.add(list.get(i));
				tmp.add(list.get(i));
			}
		}

		return tmp;
	}

	// удаляет символы из строки
	public static String deleteChar(String string, String part) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < part.length(); j++) {
				if (string.charAt(i) == part.charAt(j)) {
					break;
				}
				if (j == part.length() - 1) {
					stringBuilder.append(string.charAt(i));
				}
			}
		}
		return stringBuilder.toString();
	}

	// сортирует слова из строки
	public static String sortWord(String string) {
		String[] words = string.split("\\s+");
		System.out.println("Unsorted array: " + Arrays.toString(words));
		Arrays.sort(words);
		System.out.println("Sorted array: " + Arrays.toString(words));
		return null;
	}

	public static void exemple() {
		// System.out.println(deleteChar(string, part));

		/*
		 * \b - word boundary (граница слова) .*? - any character 0 or more
		 * times (любой символ 0 или более раз)
		 */

		System.out.println("the the my".replaceAll("(\\by.*?\\b)", ""));

		String s = " Строка, которую мы хотим разобрать на слова";
		s = s.replaceAll("[^а-яА-Я a-zA-Z]", "");
		StringTokenizer stringToken = new StringTokenizer(s, "\t\n\r,.");
		while (stringToken.hasMoreTokens()) {
			System.out.println(stringToken.nextToken());
		}

		// System.out.println(string.replaceAll());

		String str1 = "333строчка1111";
		String str2 = "строчка";
		if (str1.contains(str2)) {
			System.out.println("содержит");
		} else {
			System.out.println("НЕ содержит");
		}

		char[] mas = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char m : mas) {
			int num = (int) m;
			System.out.println(num);
		}

	}

	// корректор
	public static String correct2(String string) {

		String corString = string.trim();
		String twoSpaces = "  ";
		String oneSpace = " ";

		while (corString.contains(twoSpaces)) {
			corString = corString.replaceAll(twoSpaces, oneSpace);
		}
		return corString;
	}

}
