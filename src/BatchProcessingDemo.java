import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established Successfully");
        conn.setAutoCommit(false);

        Statement stmt = conn.createStatement();
        stmt.addBatch("Insert into worker(name, job_title, salary) values ('ramu', ' staff', 15000.00)");
        stmt.addBatch("Insert into worker(name, job_title, salary) values ('jolu', ' clerk', 25000.00)");
        stmt.addBatch("Insert into worker(name, job_title, salary) values ('sonu', ' swepper', 35000.00)");

        int[] batchResults = stmt.executeBatch();
        conn.commit();
        System.out.println("Batch executed successfully");

    }
}
