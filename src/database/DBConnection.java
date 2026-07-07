package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:3307/airbooker";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {

            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}