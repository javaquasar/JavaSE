package com.javaquasar.java.core.chapter_19_Localization.practice.task_8_10.kv;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Vitaliy on 15.01.15.
 */

class Person{
    private String name;
    private String surname;
    private String country;
    private String language;
    private String date;

    Person(String name, String surname, String country, String language, String date) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.language = language;
        this.date = date;
    }

    Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Conference{
    Person[] persons;
    String topic,city;

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    Conference() {
    }

    Conference(Person[] persons, String topic, String city) {
        this.persons = persons;
        this.topic = topic;
        this.city = city;
    }

    public void infoAboutPerson(){
        System.out.println("Topic:"+topic+"City:"+city+"\n");
        for (int i = 0; i < persons.length; i++) {
            StringBuilder builder = new StringBuilder("");
            builder.append(persons[i].toString());

            //еще дата и локальные данные
            Locale locale = new Locale(persons[i].getLanguage(),persons[i].getCountry());
            builder.append("\nКод региона :"+locale.getCountry());
            builder.append("\nНазвание региона :"+ locale.getDisplayCountry());
            builder.append("\nКод языка региона :"+locale.getLanguage());
            builder.append("\nНазвание региона :"+ locale.getDisplayLanguage());
            DateFormatSymbols formatSymbols = new DateFormatSymbols();

            String[] month = {"Ja","Fe","Mh","Ap","My","Jn","Jy","Au","Se","Oc","No","De"};

            formatSymbols.setShortMonths(month);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd & MMM & yyyy",formatSymbols);
            String tmp2 = persons[i].getDate();

            String[] tmp = tmp2.split("\\.");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(tmp[2]),Integer.valueOf(tmp[1]),Integer.valueOf(tmp[0]));
            builder.append("\nДата :" + simpleDateFormat.format(calendar.getTime()));
            System.out.println(builder.toString());
        }
    }
}

public class FormOut {
    public static void main(String[] args) {
        Person person1 = new Person("Дмитрий","Дегтярев","ua","UA","25.11.2014");
        Person person2 = new Person("Дмитрий","Болотов","bel","BY","11.6.2003");
        Person person3 = new Person("Ярослав","Орлов","en","US","5.1.2015");
        Person[] persons = {person1,person2,person3};
        Conference conference = new Conference(persons,"Java Conference","New-York");
        conference.infoAboutPerson();
    }
}
