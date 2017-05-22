package com.javaquasar.java.core.chapter_23_Regular_Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */
/*Проверка формы адреса е-mail*

 Написать программу, которая проверяет введенную строку на 
 соответствие формату адреса электронной почты. Формат адреса 
 должен соответствовать следующим правилам. Первым должно 
 идти имя учетной записи. Оно начинается с буквы латинского 
 алфавита, после которой могут следовать другие символы 
 латинского алфавита, цифры, знак подчеркивания, затем символ "@", 
 после него имя сервера. Имя сервера должно состоять из 
 нескольких частей (минимум двух), разделенных точками. 
 Последняя часть имени сервера – это имя домена первого уровня. 
 Оно может состоять только из букв латинского алфавита.*/

public class VerificationOfAddressFormEmail {

	public static final Pattern pattern = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
	
    public static void doMatch(String word) {
        String output = "Validation for \"" + word + "\"";
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches())
            output += " passed.";
        else
            output += " not passed.";
        System.out.println(output);
    }
	
    public static void main(String[] args) {
        doMatch("c0nst@money.simply.net");
        doMatch("somebody@dev");
        doMatch("Name.Sur_name@gmail.com");
        doMatch("useR33@somewhere.in.the.net");
    }

}
