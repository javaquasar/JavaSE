package core.lecture3_04_Localization.practice.task_8_09_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        Pattern pattern = Pattern.compile("[A-Za-z]\\w+@[A-Za-z]+\\.[A-Za-z]+\\.[A-Za-z]+");
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println("Строка : " + str + "  корректна");
        }
        else {
            System.out.println("Не правильная строка");
        }
    }
}
