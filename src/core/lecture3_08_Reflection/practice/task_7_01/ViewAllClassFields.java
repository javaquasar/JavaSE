package core.lecture3_08_Reflection.practice.task_7_01;

import java.util.Scanner;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ViewAllClassFields {

	private static Scanner scanner;
	private static String string;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		scanner = new Scanner(System.in);
		System.out.println("Введите полное имя класса чтобы получить список его полей");
		// scanner.nextLine();
		string = scanner.nextLine();
		// Получаем класс:
		// core.lecture3_08_Reflection.practice.task_7_01.TestClass
		Class<?> c;

		try {
			c = Class.forName(string);

			// Создаем объект:
			Object obj = null;
			try {
				obj = c.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * // Доступ к закрытому полю: Field f = c.getDeclaredField("k");
			 * f.setAccessible(true); f.set(obj, 1); // Доступ к закрытому
			 * методу: Method m = c.getDeclaredMethod("testPrivate");
			 * m.setAccessible(true); m.invoke(obj);
			 */
			/*
			 * for (int i = 0; i < obj.getClass().getMethods().length; i++) {
			 * System.out.println(obj.getClass().getMethods()[i].getName()); }
			 */

			// Method m = c.getDeclaredMethod(methodName, int.class); //
			// Определяем метод с целым параметром

			for (int i = 0; i < obj.getClass().getDeclaredMethods().length; i++) {

				int mod = obj.getClass().getDeclaredMethods()[i].getModifiers();
				if (Modifier.isPrivate(mod)) {
					System.out.print("private ");
					System.out.println(obj.getClass().getDeclaredMethods()[i].getName());

					Method m = obj.getClass().getDeclaredMethods()[i];
					m.setAccessible(true);
					m.invoke(obj);

				}
			}
			/*
			 * for (int i = 0; i < obj.getClass().getFields().length; i++) {
			 * System.out.println(obj.getClass().getFields()[i].getName()); }
			 */
			for (int i = 0; i < obj.getClass().getDeclaredFields().length; i++) {
				int mod = obj.getClass().getDeclaredFields()[i].getModifiers();
				if (Modifier.isPrivate(mod)) {
					System.out.print("private ");
					System.out.println(obj.getClass().getDeclaredFields()[i].getName());
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
