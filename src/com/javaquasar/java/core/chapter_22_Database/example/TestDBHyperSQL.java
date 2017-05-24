package com.javaquasar.java.core.chapter_22_Database.example;

import java.sql.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestDBHyperSQL {
    public static void main(String[] args) {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();

            Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:./file/22/hsqldb_country", "JavaQuasar", "1111");
            Statement stat = conn.createStatement();

            stat.executeUpdate("DROP TABLE IF EXISTS countries;");
            stat.executeUpdate("DROP TABLE IF EXISTS cities;");
            stat.executeUpdate("CREATE TABLE countries "
                    + "(country_id INTEGER IDENTITY, country_name VARCHAR(255), country_area INTEGER, "
                    + "capital VARCHAR(255), PRIMARY KEY (country_id));");

            stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital)"
                    + " VALUES ('Украина', 603628, 'Киев');");
            stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital)"
                    + " VALUES ('Германия', 357021, 'Берлин');");
            stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital)"
                    + " VALUES ('Франция', 674685, 'Марсель');");

            ResultSet rs = stat.executeQuery("SELECT country_id,"
                    + "country_name, country_area, capital FROM countries;");

            System.out.printf("%s\t  %s\t  %s\t  %s%n%n", "№", "Страна", "Территория",
                    "Столица");
            while (rs.next()) {
                System.out.printf("%s\t  %s\t  %s\t  %s%n",
                        rs.getString("country_id"),
                        rs.getString("country_name"),
                        rs.getString("country_area"),
                        rs.getString("capital"));
            }
            rs.close();
            conn.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
