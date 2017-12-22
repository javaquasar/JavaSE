package core.lecture3_08_Reflection.practice.task_7_01_2;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Class_Fields {
	
	public static void main(String[] args) {
		System.out.println(": ");
		String className = new Scanner(System.in).next();
		try{
			Class<?> c = Class.forName(className);
			for (Field f: c.getFields()){
				System.out.printf(": %s : %s%n",f.getName(),f.getType());
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("!");
		}
	}
	
}
