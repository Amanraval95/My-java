import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        String jdbc = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "Zappy888";

        try {
            Connection connection = DriverManager.getConnection(jdbc, username, password);
            System.out.println("Database connection successful.");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
