package sample.ui.Employee_Tab.DeleteEmployee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class deleteHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int id) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedDelete(conn, id);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedDelete(final Connection conn, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM `employee` WHERE `id` = ?");

        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Data deleted!");
    }
}
