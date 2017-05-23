package com.javaquasar.java.core.chapter_22_Database.example;

import java.sql.*;
/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestPreparedStatement {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver").newInstance();

            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlite:./file/22/sqlite_country_ps",
                    "JavaQuasar",
                    "1111");
            Statement stat = conn.createStatement();
            stat.executeUpdate("DROP TABLE IF EXISTS students;");
            stat.executeUpdate("CREATE TABLE students (name TEXT, surname TEXT, course INT);");
            PreparedStatement prep = conn
                    .prepareStatement("INSERT INTO students VALUES (?, ?, ?);");

            prep.setString(1, "Иван");
            prep.setString(2, "Иванов");
            prep.setString(3, "1");
            prep.addBatch();
            prep.setString(1, "Петр");
            prep.setString(2, "Петров");
            prep.setString(3, "1");
            prep.addBatch();
            prep.setString(1, "Сидор");
            prep.setString(2, "Сидоров");
            prep.setString(3, "3");
            prep.addBatch();
            prep.executeBatch();
            prep = conn.prepareStatement("SELECT * FROM students;");

            ResultSet rs = prep.executeQuery();

            System.out.printf("%s\t %s\t %s%n%n", "Имя", "Фамилия", "Курс");

            while (rs.next()) {
                System.out.printf("%s\t %s \t %s%n",
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("course"));
            }
            rs.close();
            prep.close();
            conn.close();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
