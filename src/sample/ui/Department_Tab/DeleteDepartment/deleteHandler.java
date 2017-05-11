package sample.ui.Department_Tab.DeleteDepartment;
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

    public static void createConnection(int D_ID) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedDelete(conn, D_ID);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedDelete(final Connection conn, int D_ID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM `department` WHERE `D_ID` = ?");

        ps.setInt(1, D_ID);
        ps.executeUpdate();
        System.out.println("Data deleted!");
    }
}
