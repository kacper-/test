package comt.posgtres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://172.16.216.128:5432/db";
        try {
            Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
            return;
        }
        System.out.println("Connection successful");
    }
}
