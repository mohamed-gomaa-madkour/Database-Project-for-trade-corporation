package sample.ui.Customer_Tab.DeleteCustomer;
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

    public static void createConnection(int customerID) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedDelete(conn, customerID);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedDelete(final Connection conn, int customerID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM `customer` WHERE `customerID` = ?");

        ps.setInt(1, customerID);
        ps.executeUpdate();
        System.out.println("Data deleted!");
    }
}
