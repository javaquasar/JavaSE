package com.javaquasar.java.core.chapter_13_Collections.practice;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*6.5 Данные о пользователях*

Представить данные о пользователях в виде ассоциативного массива (имя / пароль) 
с предположением, что все имена пользователей разные. 
Вывести данные о пользователях с длиной пароля более 6 символов.*/

public class UserData {

	public static void main(String[] args) {
		SortedMap<String, String> users = new TreeMap<>();
		users.put("Артур", "6037");
		users.put("Виталий", "3570210");
		users.put("Олег", "547030");
		users.put("Кирил", "5547030");
		for (Map.Entry<?, ?> user : users.entrySet()) {
			if (user.getValue().toString().length() > 6) {
				System.out.println(user.getKey() + " " + user.getValue());
			}
		}
	}

}
