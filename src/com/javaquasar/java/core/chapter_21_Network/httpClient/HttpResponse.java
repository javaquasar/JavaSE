package com.javaquasar.java.core.chapter_21_Network.httpClient;

/**
 * Created by Java Quasar on 25.05.17.
 */
public class HttpResponse {
    private int code;
    private String body;

    public HttpResponse(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "code=" + code +
                ", \nbody='" + body + '\'' +
                '}';
    }
}
