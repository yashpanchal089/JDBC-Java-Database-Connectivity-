import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingPrepStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established Successfully");
        conn.setAutoCommit(false);
        String query = "insert into worker (name, job_title, salary) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Job Title: ");
            String job_title = sc.nextLine();
            System.out.println("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            ps.setString(1, name);
            ps.setString(2, job_title);
            ps.setDouble(3, salary);
            ps.addBatch();
            System.out.println("Do you want to add  Y/N : ");
            String decision = sc.nextLine();
            if(decision.toUpperCase().equals("N")){
                break;
            }

        }

        int[] batchResult = ps.executeBatch();
        conn.commit();
        System.out.println("Batch executed");

    }
}
