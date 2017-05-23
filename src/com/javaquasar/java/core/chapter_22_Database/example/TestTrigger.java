package com.javaquasar.java.core.chapter_22_Database.example;

import java.sql.*;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TestTrigger {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:./file/22/sqlite_country_trigger", "JavaQuasar", "1111");
        Statement stat = conn.createStatement();

        stat.executeUpdate("DROP TABLE IF EXISTS leads;");
        stat.executeUpdate(
                "CREATE TABLE leads (\n" +
                " id integer PRIMARY KEY,\n" +
                " first_name text NOT NULL,\n" +
                " last_name text NOT NULL,\n" +
                " phone text NOT NULL,\n" +
                " email text NOT NULL,\n" +
                " source text NOT NULL\n" +
                ");");
        stat.executeUpdate(
                "CREATE TRIGGER validate_email_before_insert_leads BEFORE INSERT ON leads\n" +
                        "BEGIN\n" +
                        " SELECT\n" +
                        " CASE\n" +
                        " WHEN NEW.email NOT LIKE '%_@__%.__%' THEN\n" +
                        " RAISE (\n" +
                        " ABORT,\n" +
                        " 'Invalid email address'\n" +
                        " )\n" +
                        " END;\n" +
                        "END;");
        try {
            stat.executeUpdate("INSERT INTO leads (\n" +
                    " first_name,\n" +
                    " last_name,\n" +
                    " email,\n" +
                    " phone\n" +
                    ")\n" +
                    "VALUES\n" +
                    " (\n" +
                    " 'John',\n" +
                    " 'Doe',\n" +
                    " 'jjj',\n" +
                    " '4089009334'\n" +
                    " );");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stat.executeUpdate("" +
                "INSERT INTO leads (\n" +
                " first_name,\n" +
                " last_name,\n" +
                " email,\n" +
                " phone, \n" +
                " source" +
                ")\n" +
                "VALUES\n" +
                " (\n" +
                " 'John',\n" +
                " 'Doe',\n" +
                " 'john.doe@sqlitetutorial.net',\n" +
                " '4089009334', \n" +
                " 'text'" +
                " );");


        ResultSet rs = stat.executeQuery("SELECT * FROM leads;");
        System.out.printf("%s\t  %s\t  %s\t  %s\t  %s\t  %s%n%n",
                "id",
                "first_name",
                "last_name",
                "phone",
                "email",
                "source");
        while (rs.next()) {
            System.out.printf("%s\t  %s\t  %s\t  %s\t  %s\t  %s%n",
                    rs.getString("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("source"));
        }
        rs.close();
        conn.close();


    }
}
