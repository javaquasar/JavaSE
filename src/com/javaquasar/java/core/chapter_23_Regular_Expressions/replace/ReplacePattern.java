package com.javaquasar.java.core.chapter_23_Regular_Expressions.replace;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vitaliy on 11.01.15.
 */
public class ReplacePattern {
    /*
    Заменить в тексте все шаблоны типа %user%Nick%/user%
    на <a href="http://www.my.by/search.htm?param=Nick">Nick</a>.
     */


    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        Pattern pattern = Pattern.compile("%\\w+%\\w+%/\\w+%");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
           int begin  = matcher.start();
           int end = matcher.end();
           String tmp = matcher.group();
           int count = 0;
           StringBuilder nick = new StringBuilder("");

            //достаем NICK
            for (int i = 2; i <= tmp.length(); i++) {
               if(tmp.charAt(i) == '%' && count == 0)
               {
                   int j = i+1;
                   while (tmp.charAt(j) != '%'){
                       nick.append(tmp.charAt(j));
                       j++;
                   }
                   break;
               }
            }

            str = str.replaceFirst("%\\w+%\\w+%/\\w+%", "<a href=\"http://www.my.by/search.htm?param=" + nick.toString() + "\">" + nick.toString() + "</a>");
        }
        System.out.println(str);
    }
}
