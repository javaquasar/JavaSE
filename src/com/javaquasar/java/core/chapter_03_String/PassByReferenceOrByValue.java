package com.javaquasar.java.core.chapter_03_String;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Как думаете, что будет передано в метод и что напечатает код?*/
public class PassByReferenceOrByValue {
	static String str = "Value 1";

	static StringBuilder strB = new StringBuilder("Value 1"); 
	 
    public static void changeIt(StringBuilder s) { 
        s.append("2"); 
    } 
	
	public static void changeIt(String s) {
		s = "Value 2";
	}

	public static void main(String[] args) {
		changeIt(str);
		System.out.println(str);
		changeIt(strB); 
        System.out.println(strB); 
	}
}
/*Ответ - Value 1.

Раньше я думал, что раз String не примитив, то будет происходить 
передача по ссылке и новое значение ("Value 2") будет успешно присвоено.

В Java все передается по значению: и примитивы, и ссылки. Т.о. внутрь 
функции передается копия ссылки, которая ссылается на "Value 1". 
Присваивание данной копии значения другой ссылки (после чего она 
будет ссылаться на "Value 2") не влияет на объект, на который она 
изначально ссылалась.

Объект можно изменить по ссылке (если он не immutable как String):*/
