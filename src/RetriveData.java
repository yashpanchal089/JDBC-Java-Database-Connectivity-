import java.sql.*;

public class RetriveData {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String username = "root";
        String password = "Shayona@2025";
        String query = "SELECT * FROM employees";


        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded Successfully");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established Successfully");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("------------------------------");
                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Job Title : " + job_title);
                System.out.println("Salary : " + salary);
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
