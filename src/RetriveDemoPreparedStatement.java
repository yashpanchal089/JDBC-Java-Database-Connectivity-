import java.sql.*;

public class DemoPreparedStatment {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "Select * from employees where name = ? AND job_title = ?";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "yash");
            preparedStatement.setString(2, "CEO");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println("------------------------------");
                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Job Title : " + job_title);
                System.out.println("Salary : " + salary);

            }

            conn.close();
            preparedStatement.close();
            resultSet.close();
            System.out.println("Connection closed Successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
