import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class DatabaseMetaData {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String username = "root";
        String password = "Shayona@2025";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");


        try (Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection Established Successfully");

            DatabaseMetaData dbMetaData = conn.getMetaData();

            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Driver Version: " + dbMetaData.getDriverVersion());
            System.out.println("User Name: " + dbMetaData.getUserName());
            System.out.println("Supports Transactions: " + dbMetaData.supportsTransactions());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

