import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url= "jdbc:mysql://localhost:3306/javajdbc";
        String user= "root";
        String password= "Shayona@2025";
        String query = "insert into employees (id, name, job_title, salary) values (4, 'yash', 'CEO', 100000.00)";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established Successfully");
        Statement stmt = conn.createStatement();
        int rowsAffected =  stmt.executeUpdate(query);
        System.out.println("Data inserted Successfully");

        if(rowsAffected>0){
            System.out.println("Insertion successful, rows affected: " + rowsAffected);
        } else {
            System.out.println("Insertion failed, no rows affected.");
        }

        conn.close();
        stmt.close();
        System.out.println("Connection closed Successfully");


    }
}
