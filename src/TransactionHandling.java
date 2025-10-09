import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String withdrawQuery = "update accounts set balance = balance - ? where account_number = ?";
        String depositQuery = "update accounts set balance = balance + ? where account_number = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database successfully!");
            conn.setAutoCommit(false);

            try {
                PreparedStatement ws = conn.prepareStatement(withdrawQuery);
                PreparedStatement ds = conn.prepareStatement(depositQuery);

                ws.setDouble(1, 500.00);
                ws.setString(2, "account456");

                ds.setDouble(1, 500.00);
                ds.setString(2, "account46");

                int rowsAffectedWithdrawal = ws.executeUpdate();
                int rowsAffectedDeposit = ds.executeUpdate();

                if(rowsAffectedWithdrawal>0 && rowsAffectedDeposit>0){
                    conn.commit();
                    System.out.println("Transaction successful");
                } else {
                    conn.rollback();
                    System.out.println("Transaction failed, rolled back.");
                }
            } catch (SQLException e){
                conn.rollback();
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
