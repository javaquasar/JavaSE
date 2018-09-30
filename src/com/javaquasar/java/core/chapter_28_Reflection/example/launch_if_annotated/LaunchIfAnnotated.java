package com.javaquasar.java.core.chapter_28_Reflection.example.launch_if_annotated;

import java.lang.reflect.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
@Contains
class ATest {

	public void aFirst() {
		System.out.println("aFirst launched");
	}

	@ToInvoke
	public void aSecond() {
		System.out.println("aSecond launched");
	}

	public void aThird() {
		System.out.println("aThird launched");
	}
}

//@Contains
class BTest {

	@ToInvoke
	public void bFirst() {
		System.out.println("bFirst launched");
	}

	public void bSecond() {
		System.out.println("bSecond launched");
	}

	@ToInvoke
	public void bThird() {
		System.out.println("bThird launched");
	}

}

public class LaunchIfAnnotated {

	static void invokeFromClass(String className) {
		System.out.println("---------- class " + className + " ----------");
		try {
			Class<?> cls = Class.forName(className);
			if (cls.isAnnotationPresent(Contains.class)) {
				Method[] methods = cls.getMethods();
				for (Method m : methods) {
					if (m.isAnnotationPresent(ToInvoke.class)) {
						m.invoke(cls.newInstance());
					} else {
						System.out.println("No annotation before " + m.getName());
					}
				}
			} else {
				System.out.println("No annotation before" + cls.getName());
			}

		} catch (ClassNotFoundException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String classA_NameWithPath = ATest.class.getName();
		System.out.println(classA_NameWithPath);
		invokeFromClass(classA_NameWithPath);

		String classB_NameWithPath = BTest.class.getName();
		System.out.println(classB_NameWithPath);
		invokeFromClass(classB_NameWithPath);
	}

}
