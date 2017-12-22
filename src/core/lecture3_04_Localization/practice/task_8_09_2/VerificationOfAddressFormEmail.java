package core.lecture3_04_Localization.practice.task_8_09_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*8.9 Проверка формы адреса е-mail*

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

	public static final Pattern pattern = Pattern.compile("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	
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
