package com.javaquasar.java.core.chapter_22_Database.example;

import java.sql.*;
/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestDBSQLite {

    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./file/22/sqlite_country", "JavaQuasar", "1111");
        Statement stat = conn.createStatement();

        stat.executeUpdate("DROP TABLE IF EXISTS countries;");
        stat.executeUpdate("DROP TABLE IF EXISTS cities;");
        stat.executeUpdate("CREATE TABLE countries (country_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "country_name VARCHAR(255), country_area INT, capital VARCHAR(255));");

        stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) "
                + "VALUES ('Украина', 603628, 'Киев');");
        stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) "
                + "VALUES ('Германия', 357021, 'Берлин');");
        stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) "
                + "VALUES ('Франция', 674685, 'Марсель');");

        ResultSet rs = stat.executeQuery(
                "SELECT country_id,  country_name, country_area, capital FROM countries;");

        System.out.printf("%s\t  %s\t  %s\t  %s%n%n", "№", "Страна", "Территория",
                "Столица");
        while (rs.next()) {
            System.out.printf("%s\t  %s\t  %s\t  %s%n", rs.getString("country_id"),
                    rs.getString("country_name"), rs.getString("country_area"),
                    rs.getString("capital"));
        }
        rs.close();
        conn.close();
    }
}
