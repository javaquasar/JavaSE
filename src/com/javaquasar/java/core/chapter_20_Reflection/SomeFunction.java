package com.javaquasar.java.core.chapter_20_Reflection;

import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class SomeFunction {
	private Method method = null;
	private String methodName = null;
	private String className = null;

	public SomeFunction(String className, String methodName) {
		this.className = className;
		this.methodName = methodName;
	}

	public double getY(double x) throws Exception {
		if (method == null) {
			// Создаем объект типа Method, если он не был создан ранее.
			// Метод должен принимать один аргумент типа double:
			method = Class.forName(className).getMethod(methodName, double.class);
		}
		// Вызываем метод:
		return (Double) method.invoke(null, x);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите имя статического метода класса Math:");
		SomeFunction someFunction = new SomeFunction("java.lang.Math", scanner.next());
		System.out.println("Введите начало, конец интервала и шаг:");
		try {
			double from = scanner.nextDouble();
			double to = scanner.nextDouble();
			double step = scanner.nextDouble();
			for (double x = from; x <= to; x += step) {
				System.out.println(x + "\t" + someFunction.getY(x));
			}
		} catch (InputMismatchException e) {
			System.out.println("Ошибка ввода данных");
		} catch (Exception e) {
			System.out.println("Ошибка вызова функции");
		}
	}

}