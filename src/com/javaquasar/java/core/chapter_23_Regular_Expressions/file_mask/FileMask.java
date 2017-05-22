package com.javaquasar.java.core.chapter_23_Regular_Expressions.file_mask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */

/*Маска файла*

Вывести имена файлов, удовлетворяющих маске файла. 
Файл должен начинаться на определенное сочетание букв, 
первая буква должна быть задана как вариант из двух букв, 
длина имени не определена, расширение файла задать как 
одно из трех возможных вариантов. Имя папки файла задать точно.*/

public class FileMask {

	public static void main(String[] args) {
		String[] str = {"folder/a.txt", "folder/ab.txt", "folder/abv.txt", "folder/b.txt", "folder/a.doc", "folder/c.txt"};
		Pattern p = Pattern.compile("folder/(b|a).*.(txt|doc|rtf)");
		Matcher m;
		for(String s : str) {
			m = p.matcher(s);
			if (m.matches()) {
				System.out.println(s);
			}
		}
		
	}

}
