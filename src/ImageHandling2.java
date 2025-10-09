import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageHandling2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String password = "Shayona@2025";
        String folder_path = "E:\\Linkedin Post Image\\";
        String query = "select image_data from image_table where image_id = (?);";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established Successfully");

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,1);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                byte[] imageData = rs.getBytes("image_data");
                String image_path = folder_path + "image1.jpg";
                OutputStream os = new FileOutputStream(image_path);
                os.write(imageData);
            } else {
                System.out.println("Image not found");
            }

            conn.close();
            System.out.println("Connection closed Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
