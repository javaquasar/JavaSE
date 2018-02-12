package com.javaquasar.java.core.chapter_17_Date.example.simpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Java Quasar on 07.02.18.
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        java_6();

        String date =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(new Locale("ru"))
                        .format(LocalDate.of(2014, 2, 28));
        System.out.println(date);
        java_8();
    }

    public static void java_6() throws ParseException {
        //On my JDK-6-installation I can reproduce your problem:
        Date jud = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-28");
        String month = DateFormat.getDateInstance(SimpleDateFormat.FULL, new Locale("ru")).format(jud);
        System.out.println(month); // output: 28 Февраль 2014 г.
    }

    public static void java_8() throws ParseException {
        // In short: The "LLLL" pattern will get a Nominative case:
        System.out.println(new SimpleDateFormat("dd LLLL", new Locale("ru")).format(new Date()));
        // The "MMMM" pattern will return a String in Genitive case:
        System.out.println(new SimpleDateFormat("dd MMMM", new Locale("ru")).format(new Date()));
    }

}
