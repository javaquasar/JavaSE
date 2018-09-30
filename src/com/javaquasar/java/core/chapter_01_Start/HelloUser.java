package com.javaquasar.java.core.chapter_01_Start;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class HelloUser {

	public static void main(String[] args) {
if (args.length > 0)
			System.out.println("Привет, " + args[0] + "!");
		else
			System.out.println("Привет, незнакомец!");

	}

}

