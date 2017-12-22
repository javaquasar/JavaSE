package com.javaquasar.java.core.chapter_13_Collections.example.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class LoopWithMap {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
		/*
		 * 0. Обращение Map в List В Java, интерфейс Map предлагает три вида
		 * коллекций: набор ключей, набор значений и набор ключ-значение. Все
		 * они могут быть обращены в List при помощи конструктора или метода
		 * addAll(). Следующая вырезка кода демонстрирует как сделать ArrayList
		 * из Map.
		 */
		// лист ключей
		List<String> keyList = new ArrayList<>(map.keySet());
		LinkedList<String> list = new LinkedList<>();
		
		System.out.println("keyList " + keyList);
		// лист значений
		List<Integer> valueList = new ArrayList<>(map.values());
		System.out.println("valueList " + valueList);
		// лист ключ-значения
		List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		System.out.println("entryList " + entryList);

		// 1. Пройтись по всем значениям в Map.
		// Проход по каждой паре ключ-значение — самая базовая, основная
		// процедура прохода по Map.
		// В Java, каждая пара хранится в поле Map называемом Map.Entry.
		// Map.entrySet() возвращает
		// набор ключ-значений, потому самым эффективным способом пройтись по
		// всем значениям Map
		// будет:
		System.out.println("For each --------------------");
		for (Entry<String, Integer> entry : map.entrySet()) {
			// получить ключ
			String key = (String) entry.getKey();
			// получить значение
			Integer value = (Integer) entry.getValue();
			System.out.println(key + " " + value);
		}

		// Так же мы можем использовать Iterator, особенно в версиях младше JDK
		// 1.5
		System.out.println("While --------------------");
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Integer> entry = (Entry<String, Integer>) itr.next();
			// получить ключ
			String key = (String) entry.getKey();
			// получить значение
			Integer value = (Integer) entry.getValue();
			System.out.println(key + " " + value);
		}

		/*
		 * 4. Инициализация статической/неизменной Map Когда вы желаете, что бы
		 * Map оставалась неизменной, хорошим способом будет скопировать оную в
		 * неизменяемую (immutable) Map. Такая защитная техника программирования
		 * поможет вам создать не только безопасную для использования, но и так
		 * же потокобезопасную Map. Для инициализации статической/неизменной
		 * Map, мы можем использовать инициализатор static (см. ниже). Проблема
		 * данного кода в том, что не смотря на объявление Map как static final,
		 * мы всё ещё можем работать с ней после инициализации, например
		 * Test.Map.put(3,«three»);. Так что это не настоящая неизменность. Для
		 * создания неизменяемой Map с использованием статического
		 * инициализатора, нам нужен супер анонимный класс, который мы добавим в
		 * неизменяемую Map на последнем шаге инициализации. Пожалуйста,
		 * посмотрите на вторую часть кода. Когда будет выброшено
		 * UnsupportedOperationException, если вы запустите
		 * Test.Map.put(3,«three»);
		 */
		Map<String, Integer> mapUnmodifiable = Collections.unmodifiableMap(map);

		/*
		 * 7. Поверхностная копия Map Почти все, если не все, Map в Java
		 * содержат конструктор копирования другой Map. Но процедура копирования
		 * не синхронизирована. Что означает когда один поток копирует Map,
		 * другой может изменить её структуру. Для предотвращения внезапной
		 * рассинхронизации копирования, один из них должен использовать в таком
		 * случае Collections.synchronizedMap().
		 */

		Map<String, Integer> copiedMap = Collections.synchronizedMap(map);

		/*
		 * Другой интересный способ поверхностного копирования — использование
		 * метода clone(). Но он НЕ рекомендуется даже создателем фреймворка
		 * коллекций Java, Джоном Блохом. В споре
		 * "Конструктор копирования против клонирования", он занимает позицию:
		 * Цитата: «Я часто привожу публичный метод clone в конкретных классах,
		 * поскольку люди ожидают их там увидеть.… это позор, что Клонирование
		 * сломано, но это случилось.… Клонирование это слабое место, и я думаю
		 * люди должны быть предупреждены о его ограничениях.» По этой причине,
		 * я даже не показываю вам, как использовать метод clone() для
		 * копирования Map
		 */

		/*
		 * 8. Создание пустой Map Если Map неизменна, используйте
		 */
		Map mapEmpty = Collections.emptyMap();
	}
}
