package core.lecture3_08_Reflection.practice.task_7_04;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/*7.4 Вычисление значение выражения*

реализовать предыдущее задание с вводом с клавиатуры значение аргумента и использованием
средств динамической компиляции кода. Добавить возможность вызова математических функций Java.*/

public class StringProcessor {
	  final String sourceFile = "./bin/core/lecture3_08_Reflection/practice/task_7_04/StringTest.java";

	  void genSource(String expression) {
	    try (PrintWriter out = new PrintWriter(sourceFile)) {
	      out.println("package core.lecture3_08_Reflection.practice.task_7_04;");
	      out.println("public class StringTest {");
	      out.println("    public static Double transform(Double x) {");
	      out.println("        Double z = "+ expression+";");
	      out.println("        return z;");
	      out.println("    }");
	      out.println("}");
	    }
	    catch (IOException e) {
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
	    System.out.println("Введите выражение, которое нужно расчитать с аргументом х:");
	    String expression = scan.nextLine().replaceAll("\"", "\\\"");
	    sp.genSource(expression);
	    try {
	      if (sp.compile()) {
	        System.out.println("Введите значение аргумента х:");
	        Double s = scan.nextDouble();
	        Class<?> cls = Class.forName("core.lecture3_08_Reflection.practice.task_7_04.StringTest");
	        Method m = cls.getMethod("transform", Double.class);
	        System.out.println(m.invoke(null, new Object[] { s }));
	      }
	      else {
	        System.out.println("Ошибка ввода выражения!");
	      }
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}