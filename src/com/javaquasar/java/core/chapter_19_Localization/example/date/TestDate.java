package com.javaquasar.java.core.chapter_19_Localization.example.date;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestDate {
    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = new Date();
        String form = dateFormat.format(date);
        System.out.println(form);
    }
}
