import java.sql.*;

public class ResultSetMetaDataDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "SELECT * FROM worker";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established Successfully");

        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        System.out.println("----------------------------");
        for(int i =1; i<=columnCount; i++){
            System.out.println("Column " + i + ":");
            System.out.println("Name: " + rsmd.getCatalogName(i));
            System.out.println("Type: " + rsmd.getColumnTypeName(i));
            System.out.println("Display Size: " + rsmd.getColumnDisplaySize(i));
            System.out.println("----------------------------");
        }

        conn.close();
        ps.close();
        rs.close();
        System.out.println("Connection closed Successfully");

    }
}
