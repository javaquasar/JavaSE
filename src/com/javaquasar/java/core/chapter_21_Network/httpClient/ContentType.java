package com.javaquasar.java.core.chapter_21_Network.httpClient;

/**
 * Created by Java Quasar on 25.05.17.
 */
public enum ContentType {
    XML("text/xml;charset=UTF-8");

    private String typeName;

    private ContentType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}