package com.javaquasar.java.core.chapter_17_Date.example.zoned_date_time.kv;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Person{

    String name, surname, sex;
    Calendar calendar;

    Person(String name, String surname, String sex) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    Person(String name, String surname, String sex,int year,int month,int day) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        calendar = new GregorianCalendar();
        calendar.set(year,month,day);
    }

    public String getAge(){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = calendar.toInstant();
        ZonedDateTime zonedBirthday =  ZonedDateTime.ofInstant(instant,zoneId);
        ZonedDateTime zonedNow = ZonedDateTime.now();
        return String.valueOf(zonedNow.getYear() - zonedBirthday.getYear());
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + getAge() +
                '}';
    }
}

public class PersonMain {
    public static void main(String[] args) {
       Person person = new Person("Vitaliy","Tram","Male", 1996, 6 , 27);
        System.out.println(person.getAge());
        System.out.println(person);
    }
}
