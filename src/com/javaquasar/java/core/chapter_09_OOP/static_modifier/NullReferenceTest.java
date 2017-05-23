package com.javaquasar.java.core.chapter_09_OOP.static_modifier;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Измените код так, чтобы он вернул hello world на консоль.
 * Ограничения - нельзя создавать новые объекты. 
 * Нельзя изменять текущий код, можно только добавить немного своего.*/
public class NullReferenceTest {
	
	private static String hello = "HelloWord!";// Добавил
	
	public static void main(String[] args) { 
        NullReferenceTest nullReferenceTest = null; 
        System.out.println(nullReferenceTest.hello/*<some descriptor>*/); 
    } 
}

/*Через null ссылку можно обратиться к статике, следовательно могут быть такие варианты:

1) Добавить в класс NullReferenceTest статическое поле string со значение "hello world"
2) Добавить статический метод*/