
# 🧠 PreparedStatement in JDBC
[![Typing SVG](https://readme-typing-svg.herokuapp.com?size=24&color=00CFFF&lines=PreparedStatement+in+JDBC+💡;Execute+Parameterized+Queries;Secure+%26+Efficient;Precompiled+SQL+Statements;Real+Life+Examples+Included)](https://git.io/typing-svg)

---

## 🔹 Concept

Prepared statements are a feature in database programming, commonly used in **JDBC** and other data access libraries.

They are used to execute **SQL queries with placeholders** for parameters.  
These placeholders (`?`) are filled with specific values when the query is executed.

---

## ✅ Advantages

1. 🛡️ **Protection against SQL Injection** — parameters are treated as data, not code.  
2. ⚡ **Improved Performance** — query is precompiled and reused.  
3. 🧾 **Code Readability & Maintainability** — easy to understand with placeholders.  
4. 🔢 **Automatic Data Type Handling** — no need to manually format SQL strings.  
5. 🌍 **Portability** — works across various databases.

---

## 🏠 Real-Life Analogy

Imagine you run a **pizza shop 🍕**.

You have an order form that says:
> “Make a pizza with ___ size and ___ topping.”

You don’t rewrite the whole order every time —  
you just fill in the blanks with different values.

That’s what a **PreparedStatement** does!  
The SQL query is the **template**, and the values you insert are the **blanks**.

---

## 💻 Example 1: Insert Record using PreparedStatement

```java
import java.sql.*;

public class InsertDemoPreparedStatement {

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "INSERT INTO employees (id, name, job_title, salary) VALUES (?, ?, ?, ?)";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Pritesh");
            preparedStatement.setString(3, "CTO");
            preparedStatement.setInt(4, 666666);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
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
```

## 💻 Example 2: Retrieve Record using PreparedStatement
```sql
import java.sql.*;

public class RetrieveDemoPreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "SELECT * FROM employees WHERE name = ? AND job_title = ?";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "Yash");
            preparedStatement.setString(2, "CEO");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
```
## 💻 Example 3: Insert Record with User Input (Scanner)
```sql
import java.sql.*;
import java.util.Scanner;

public class UserInputDemoPreparedStatement {

    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String query = "INSERT INTO employees (id, name, job_title, salary) VALUES (?, ?, ?, ?)";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded Successfully");

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Job Title: ");
            String job_title = sc.nextLine();
            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, job_title);
            preparedStatement.setInt(4, salary);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
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
```

## 🧾 Key Takeaway

- PreparedStatement = Safe + Efficient + Reusable SQL Query
- Helps prevent SQL injection, improves performance, and keeps code clean.

## 📘 Related Topics
- `Statement` vs `PreparedStatement`
- `CallableStatement` for stored procedures
- SQL Injection Prevention Techniques
- JDBC Connection Pooling
