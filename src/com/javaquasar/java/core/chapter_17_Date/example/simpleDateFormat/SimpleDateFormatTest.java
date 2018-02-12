package com.javaquasar.java.core.chapter_17_Date.example.simpleDateFormat;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
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
        Date date = new Date();
        java_6(date);

        String dateString =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(new Locale("ru"))
                        .format(LocalDate.of(2014, 2, 28));
        System.out.println(dateString);
        java_8(date);

        custom(date, "dddd M");
    }

    public static void java_6(Date date) throws ParseException {
        //On my JDK-6-installation I can reproduce your problem:
        //Date jud = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-28");
        String month = DateFormat.getDateInstance(SimpleDateFormat.FULL, new Locale("ru")).format(date);
        System.out.println(month); // output: 28 Февраль 2014 г.
    }

    public static void java_8(Date date) throws ParseException {
        // In short: The "LLLL" pattern will get a Nominative case:
        System.out.println(new SimpleDateFormat("dd LLLL", new Locale("ru")).format(date));
        // The "MMMM" pattern will return a String in Genitive case:
        System.out.println(new SimpleDateFormat("dd MMMM", new Locale("ru")).format(date));
    }

    public static String custom(Date date, String format) throws ParseException {
        Locale locale = new Locale("ru");
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        String[] months = {
                "января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        String[] shortMonths = {
                "янв", "фев", "мар", "апр", "май", "июн",
                "июл", "авг", "сен", "окт", "ноя", "дек"};
        dfs.setMonths(months);
        dfs.setShortMonths(shortMonths);
        String[] weekdays = {"", "Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
        String[] shortWeekdays = {"", "вс", "пн", "вт", "ср", "чт", "пт", "сб"};
        dfs.setWeekdays(weekdays);
        dfs.setShortWeekdays(shortWeekdays);

        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        sdf.setDateFormatSymbols(dfs);
        return sdf.format(date); // пт, 09 декабря 2016
    }


}
