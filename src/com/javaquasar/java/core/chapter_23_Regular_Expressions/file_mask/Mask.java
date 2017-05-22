package com.javaquasar.java.core.chapter_23_Regular_Expressions.file_mask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Mask {
    public static void main(String[] args) {
        String[] names = {"nix/myformat.java","nix/matrix.java","nixx/matrix.java","nix/sumofbigger.class","io/sortarray.java"
        ,"nix/sumofelements.txt","nix/sumofelement.txt"};
        Pattern pattern = Pattern.compile("nix/[msMS]\\w+\\.(java|class|txt)");
        Matcher matcher;
        for (String name : names) {
            matcher = pattern.matcher(name);
            if(matcher.matches()){
                System.out.println(name);
            }
        }

    }
}
