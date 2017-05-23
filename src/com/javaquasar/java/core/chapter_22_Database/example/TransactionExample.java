package com.javaquasar.java.core.chapter_22_Database.example;

import java.sql.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TransactionExample {
    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection("jdbc:h2:./file/22/h2_country_transaction", "JavaQuasar", "1111");

            conn.setAutoCommit(false); //сброс режима автоматического подтверждения операций

            Statement stat = conn.createStatement();
            ResultSet rs = null;
            try {
                stat.executeUpdate("DROP TABLE IF EXISTS countries;");
                stat.executeUpdate("DROP TABLE IF EXISTS cities;");
                stat.executeUpdate("CREATE TABLE countries (country_id INT NOT NULL AUTO_INCREMENT, "
                        + "country_name VARCHAR(255), country_area INT, capital VARCHAR(255), PRIMARY KEY (country_id));");
                stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) VALUES ('Украина', 603628, 'Киев');");
                // Можно установить точку сохранения, до которой может быть произведен откат:
                // Savepoint savepoint = conn.setSavepoint("savepoint 1");
                // cn.rollback(savepoint);
                stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) VALUES ('Германия', 357021, 'Берлин');");
                stat.executeUpdate("INSERT INTO countries (country_name, country_area, capital) VALUES ('Франция', 674685, 'Марсель');");
                rs = stat.executeQuery("SELECT country_id,  country_name, country_area, capital FROM countries;");

                conn.commit(); //подтверждение успешного завершения транзакции
                System.out.println("Транзакция прошла успешно");
            } catch (SQLException e) {
                conn.rollback(); //откат транзакции
                System.out.println("Произведен откат транзакции" + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stat != null) {
                        stat.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

