package com.javaquasar.java.core.chapter_02_Primitive_Data_Types.type_conversion_and_casting;

/**
 * Created by Java Quasar on 16.05.17.
 */
//Demonstrate casts.
class Conversion {
	public static void main(String args[]) {
		byte b;
		int i = 257;
		double d = 323.142;
		System.out.println("\nConversion of int to byte.");
		b = (byte) i;
		System.out.println("i and b " + i + " " + b);
		System.out.println("\nConversion of double to int.");
		i = (int) d;
		System.out.println("d and i " + d + " " + i);
		System.out.println("\nConversion of double to byte.");
		b = (byte) d;
		System.out.println("d and b " + d + " " + b);
		
		int v1=1; 
		long v2=2; 
		//System.out.println(v1=v1+v2);  
		
		int v1_=1; 
		long v2_=2; 
		System.out.println(v1_+=v2_); 
		
		/*При сокращённых операциях в java производится приведение типов. 
		 * То есть v1+=v2 аналогична v1=(int)(v1+v2) Соответственно в первой 
		 * строке будет ошибка компиляции так как long шире чем int, а 
		 * вторая строка успешно выполнится.*/
		
	}
}