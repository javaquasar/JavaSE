package com.javaquasar.java.core.chapter_21_Network.httpClient;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Java Quasar on 25.05.17.
 */
public class HttpClient {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String UTF_8 = "UTF-8";

    public static void main(String[] args) throws Exception {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("q", "mkyong");

        HttpResponse httpResponse = send("http://www.google.com/search", RequestType.GET, ContentType.XML, queryParams, null);
        System.out.println(httpResponse);
    }

    public static HttpResponse send(String url,
                                    RequestType requestType,
                                    ContentType contentType,
                                    Map<String, String> queryParams,
                                    String body) throws IOException {

        HttpURLConnection connection = getConnection(url + getQueryParams(queryParams));
        connection.setRequestMethod(requestType.getTypeName());
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Content-Type", contentType.getTypeName());
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        switch (requestType) {
            case GET:
                break;
            case POST:
                connection.setDoOutput(true);
                try(OutputStream outputStream = connection.getOutputStream();
                    DataOutputStream wr = new DataOutputStream(outputStream)) {
                    wr.writeBytes(body);
                }
                break;
        }

        int responseCode = connection.getResponseCode();
        return new HttpResponse(responseCode, getBody(connection));
    }

    public static String getQueryParams(Map<String, String> queryParams) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("?");
        if (queryParams != null) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), UTF_8));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), UTF_8));
            }
        }
        return sb.toString();
    }

    public static HttpURLConnection getConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return con;
    }

    public static String getBody(HttpURLConnection connection) throws IOException {
        if (connection != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        return null;
    }

    private void printHttpsCert(HttpsURLConnection con) {
        if (con != null) {
            try {
                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");

                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : "
                            + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : "
                            + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }
            } catch (SSLPeerUnverifiedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
