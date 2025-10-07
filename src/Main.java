//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully!");
            System.out.println(conn);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }

    }
}
