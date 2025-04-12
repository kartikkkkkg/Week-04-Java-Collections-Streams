import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public void manageConnection(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}