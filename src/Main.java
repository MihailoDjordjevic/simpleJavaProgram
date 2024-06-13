import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Heyyy");

        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "";

        String query = "INSERT INTO user (username, email) VALUES ('Bogdan', 'bogi@gmail.com')";

        Connection conn;
        PreparedStatement pstmt;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(url, user, password);

            // Prepare the SQL statement
            pstmt = conn.prepareStatement(query);

//            // Set parameters for the SQL statement
//            pstmt.setString(1, "john_doe");
//            pstmt.setString(2, "john.doe@example.com");

            // Execute the insert statement
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error occurred while inserting data into the database.");
            e.printStackTrace();
        }
    }

}
