package sample.ui.Vendor_Tab.AddVendor;
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

    public static void createConnection(int vendorID, String vendorName, int vendorPhone, String vendorAddress) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, vendorID, vendorName, vendorPhone, vendorAddress);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int vendorID, String vendorName, int vendorPhone, String vendorAddress) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `vendor` (`vendorID`, `vendorName`, `vendorPhone`, `vendorAddress` ) VALUES (?,?,?,?)");

        ps.setInt(1, vendorID);
        ps.setString(2, vendorName);
        ps.setInt(3, vendorPhone);
        ps.setString(4, vendorAddress);
        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
