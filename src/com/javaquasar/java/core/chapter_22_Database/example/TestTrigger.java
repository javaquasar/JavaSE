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
        stat.executeUpdate("DROP TABLE IF EXISTS lead_logs;");
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
                "CREATE TABLE lead_logs (\n" +
                        " id INTEGER PRIMARY KEY,\n" +
                        " old_id int,\n" +
                        " new_id int,\n" +
                        " old_phone text,\n" +
                        " new_phone text,\n" +
                        " old_email text,\n" +
                        " new_email text,\n" +
                        " user_action text,\n" +
                        " created_at text\n" +
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

        stat.executeUpdate(
                "CREATE TRIGGER log_contact_after_update AFTER UPDATE ON leads\n" +
                        "WHEN old.phone <> new.phone\n" +
                        "OR old.email <> new.email\n" +
                        "BEGIN\n" +
                        " INSERT INTO lead_logs (\n" +
                        " old_id,\n" +
                        " new_id,\n" +
                        " old_phone,\n" +
                        " new_phone,\n" +
                        " old_email,\n" +
                        " new_email,\n" +
                        " user_action,\n" +
                        " created_at\n" +
                        " )\n" +
                        "VALUES\n" +
                        " (\n" +
                        " old.id,\n" +
                        " new.id,\n" +
                        " old.phone,\n" +
                        " new.phone,\n" +
                        " old.email,\n" +
                        " new.email,\n" +
                        " 'UPDATE',\n" +
                        " DATETIME('NOW')\n" +
                        " ) ;\n" +
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

        stat.executeUpdate("UPDATE leads\n" +
                "SET last_name = 'Smith'\n" +
                "WHERE\n" +
                " id = 1;");
        stat.executeUpdate("UPDATE leads\n" +
                "SET phone = '4089998888',\n" +
                " email = 'john.smith@sqlitetutorial.net'\n" +
                "WHERE\n" +
                " id = 1;");

        rs = stat.executeQuery("SELECT\n" +
                " old_phone, new_phone, old_email, new_email, user_action\n" +
                "FROM\n" +
                " lead_logs;");

        while (rs.next()) {
            System.out.printf("%s\t  %s\t%n",
                    rs.getString("old_phone"),
                    rs.getString("new_phone")
                    );
            System.out.printf("%s\t  %s\t%n",
                    rs.getString("old_email"),
                    rs.getString("new_email")
            );
            System.out.printf("%s\t  %s\t%n",
                    rs.getString("old_phone"),
                    rs.getString("new_phone")
            );
            System.out.printf("%s%n",
                    rs.getString("user_action")
            );
        }
        rs.close();
        conn.close();


    }
}
