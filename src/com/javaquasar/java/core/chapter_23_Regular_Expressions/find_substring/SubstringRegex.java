package com.javaquasar.java.core.chapter_23_Regular_Expressions.find_substring;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vitaliy on 11.01.15.
 */
public class SubstringRegex {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        Pattern pattern = Pattern.compile("[abc]{1}[0-9]{1}\\w");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group() + " начиная с :" + matcher.start() +"закачивая :" + matcher.end());
            System.out.println();
        }
    }
}
