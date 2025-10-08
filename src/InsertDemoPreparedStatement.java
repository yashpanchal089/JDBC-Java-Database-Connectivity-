import java.sql.*;

public class InsertDemoPreparedStatement {

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "INSERT INTO employees (id, name, job_title, salary) VALUES (?, ?, ?, ?)";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Pritesh");
            preparedStatement.setString(3, "CTO");
            preparedStatement.setInt(4, 666666);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Insertion successful, rows affected: " + rowsAffected);
            } else {
                System.out.println("Insertion failed, no rows affected.");
            }



            conn.close();
            preparedStatement.close();
            System.out.println("Connection closed Successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
