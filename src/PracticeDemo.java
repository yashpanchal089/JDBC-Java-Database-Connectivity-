import java.sql.*;
import java.util.stream.StreamSupport;

public class PracticeDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String username = "root";
        String password = "Shayona@2025";
//        String query = "INSERT into employees(id, name, job_title, salary) values (9, 'Alert', 'CMO', 636366);";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded Successfully");

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established Successfully");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, job_title, salary FROM employees;");
//        int rowsAffected = stmt.executeUpdate(query);

        while(rs.next()){
            int id = rs.getInt("id" );
            String name = rs.getString("name");
            System.out.println("ID: " + id );
            System.out.println("Name: " + name);
            System.out.println("-------------------");
        }
//
//        if(rowsAffected>0){
//            System.out.println("Insertion Successful, rows affected: " + rowsAffected);
//        } else {
//            System.out.println("Insertion Failed, no rows affected.");
//        }

        conn.close();
        stmt.close();
        System.out.println("Connection Closed Successfully");



    }
}
