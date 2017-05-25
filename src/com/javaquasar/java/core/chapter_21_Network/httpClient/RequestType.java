package com.javaquasar.java.core.chapter_21_Network.httpClient;

/**
 * Created by Java Quasar on 25.05.17.
 */
public enum RequestType {
    GET("GET"),
    POST("POST");

    private String typeName;

    private RequestType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
