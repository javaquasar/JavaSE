package com.javaquasar.java.core.chapter_28_Reflection.example;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Scanner;
import javax.tools.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class StringProcessor {
	final String sourceFile = "com/javaquasar/java/core/chapter_28_Reflection/StrFun.java";

	void genSource(String expression) {
		try (PrintWriter out = new PrintWriter(sourceFile)) {
			out.println("package com.javaquasar.java.core.chapter_18_Reflection;");
			out.println("public class StrFun {");
			out.println("  public static String transform(String s) {");
			out.println("    return " + expression + ";");
			out.println("  }");
			out.println("}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	boolean compile() {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		return compiler.run(null, null, null, sourceFile) == 0;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		StringProcessor sp = new StringProcessor();
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите выражение, которое нужно выполнить над строкой s:");
		String expression = scan.nextLine().replaceAll("\"", "\\\"");
		sp.genSource(expression);
		try {
			if (sp.compile()) {
				System.out.println("Введите строку s:");
				String s = scan.nextLine();
				Class<?> cls = Class.forName("com.javaquasar.java.core.chapter_28_Reflection.StrFun");
				Method m = cls.getMethod("transform", String.class);
				System.out.println(m.invoke(null, new Object[] { s }));
			} else {
				System.out.println("Ошибка ввода выражения!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
