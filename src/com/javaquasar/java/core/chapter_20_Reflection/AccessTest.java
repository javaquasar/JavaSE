package com.javaquasar.java.core.chapter_20_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Java Quasar on 16.05.17.
 */
class TestClass {
	private int privatVariable = 0;

	private void privateMethod() {
		System.out.println("Закрытый метод. privatVariable = " + privatVariable);
	}

}

public class AccessTest {

	public static void main(String[] args) throws Exception {
		String classNameWithPath = TestClass.class.getName();
		System.out.println(classNameWithPath);

		// Получаем класс:
		Class<?> c = Class.forName(classNameWithPath);
		// Создаем объект:
		Object obj = c.newInstance();
		// Доступ к закрытому полю:
		Field f = c.getDeclaredField("privatVariable");
		f.setAccessible(true);
		f.set(obj, 1);
		// Доступ к закрытому методу:
		Method m = c.getDeclaredMethod("privateMethod");
		m.setAccessible(true);
		m.invoke(obj);
	}

}
