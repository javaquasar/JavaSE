package com.javaquasar.java.core.chapter_18_XML.serialization;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class Line implements java.io.Serializable {

    private static final long serialVersionUID = 5364062177715773963L;
    private Point first = new Point(), second = new Point();

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

}
