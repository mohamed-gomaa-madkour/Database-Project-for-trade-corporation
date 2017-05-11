package sample.ui.Customer_Tab.AddCustomer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class addHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int customerID, String customerName, int customerPhone) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, customerID, customerName, customerPhone);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int customerID, String customerName, int customerPhone) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `customer` (`customerID`, `customerName`, `customerPhone`) VALUES (?,?,?)");

        ps.setInt(1, customerID);
        ps.setString(2, customerName);
        ps.setInt(3, customerPhone);
        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
