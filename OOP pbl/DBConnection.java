import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/academic_movie_booking"; // Replace with your DB name
    private static final String USER = "root";    // Your MySQL username
    private static final String PASSWORD = "Afeefa@12"; // Your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
