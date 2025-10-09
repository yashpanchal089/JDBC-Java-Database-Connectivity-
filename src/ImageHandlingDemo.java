import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageHandlingDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String image_table = "E:\\Linkedin Post Image\\image1.jpg";
        String query = "Insert INTO image_table(image_data) values(?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            FileInputStream fis = new FileInputStream(image_table);
            byte [] imageData = new byte[fis.available()];
            fis.read(imageData);

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setBytes(1, imageData);

            int affectedRows = ps.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Image inserted successfully, rows affected: ");
            } else {
                System.out.println("Image insertion failed, no rows affected.");
            }

            conn.close();
            System.out.println("Connection closed Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
