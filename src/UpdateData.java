import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url= "jdbc:mysql://localhost:3306/javajdbc";
        String user= "root";
        String password= "Shayona@2025";
        String query = "UPDATE Employees set salary = 9999999.00 where id = 4;";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established Successfully");
        Statement stmt = conn.createStatement();
        int rowsAffected =  stmt.executeUpdate(query);
        System.out.println("Data Updated Successfully");

        if(rowsAffected>0){
            System.out.println("Update successful, rows affected: " + rowsAffected);
        } else {
            System.out.println("Update failed, no rows affected.");
        }

        conn.close();
        stmt.close();
        System.out.println("Connection closed Successfully");


    }
}
