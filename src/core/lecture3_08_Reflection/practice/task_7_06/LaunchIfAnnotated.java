package core.lecture3_08_Reflection.practice.task_7_06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LaunchIfAnnotated {

	static void invokeFromClass(String className) {
		System.out.println("---------- class " + className + " ----------");
		try {
			Class<?> cls = Class.forName(className);
			if (cls.isAnnotationPresent(Contains.class)) {
				Method[] methods = cls.getMethods();
				for (Method m : methods) {
					if (m.isAnnotationPresent(ToInvoke.class)) {
						if (m.getAnnotation(ToInvoke.class).run() == true) {
							m.invoke(cls.newInstance());
						} else
							System.out.println("No annotation before " + m.getName());
					}
				}
			} else {
				System.out.println("No annotation before" + cls.getName());
			}

		} catch (ClassNotFoundException | 
				 SecurityException | 
				 InstantiationException | 
				 IllegalAccessException | 
				 IllegalArgumentException | 
				 InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		invokeFromClass("core.lecture3_08_Reflection.practice.task_7_06.TestClassA");
		invokeFromClass("core.lecture3_08_Reflection.practice.task_7_06.TestClassB");
	}

}