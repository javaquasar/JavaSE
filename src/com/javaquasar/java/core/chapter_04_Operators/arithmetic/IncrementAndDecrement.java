package com.javaquasar.java.core.chapter_04_Operators.arithmetic;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class IncrementAndDecrement {

	public static void main(String[] args) {

		// (1)
		int i = 5;
		i = i++;
		System.out.println(i);

		// (2)
		i = 5;
		i = i++ + i++;
		System.out.println(i);

		// (3)
		i = 5;
		i = i++ + ++i;
		System.out.println(i);

		// (4)
		i = 5;
		i = ++i + ++i;
		System.out.println(i);
	}

}

/*В первом случае, k = 5 +1, затем k = 5; 
 * Пост инкремент не передает значение сразу. Ответ 5.

В втором случае, сначала инкременты, второй инкремент получает 
уже инкрементное значение. Т.к. это пост-инкременты конечно выражение i = 5 +6; Ответ 11.

В третьем, похоже на второй, только конечное выражение будет таким i = 5 + 7; Ответ 12.

В четвертом, аналагично, только конечное выражение i = 6 +7; Ответ 13.*/
