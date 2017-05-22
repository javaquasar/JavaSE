package com.javaquasar.java.core.chapter_14_Enum.practice.month;

/**
 * Created by Java Quasar on 16.05.17.
 */
public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    private int numberOfDays;

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Season getSeason() {
        switch (this) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return Season.WINTER;
            case MARCH:
            case APRIL:
            case MAY:
                return Season.SPRING;
            case JUNE:
            case JULY:
            case AUGUST:
                return Season.SUMMER;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return Season.AUTUMN;
        }
        return null;
    }

    public Month getNextMonth() {
        Month[] month = Month.values();

        int number = this.ordinal();

        if (number == 11) {
            return month[0];
        } else {
            return month[number + 1];
        }
    }

    public Month getLastMonth() {
        Month[] month = Month.values();

        int number = this.ordinal();

        if (number == 0) {
            return month[11];
        } else {
            return month[number - 1];
        }
    }

    @Override
    public String toString() {
        return "Month - " + this.name() + " number of days = " + getNumberOfDays();
    }

    static void printAll() {
        for (Month d : values())
            System.out.println(d);
    }
}
