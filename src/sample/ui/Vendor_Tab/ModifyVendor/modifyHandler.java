package sample.ui.Vendor_Tab.ModifyVendor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class modifyHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int vendorID, String vendorName, int vendorPhone, String vendorAddress,  int id) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, vendorID, vendorName, vendorPhone, vendorAddress,  id);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int vendorID, String vendorName, int vendorPhone, String vendorAddress,  int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE `vendor` SET `vendorID`=?,`vendorName`=?,`vendorPhone`=?, `vendorAddress`=? WHERE `vendorID` = ?");

        ps.setInt(1, vendorID);
        ps.setString(2, vendorName);
        ps.setInt(3, vendorPhone);
        ps.setString(4, vendorAddress);
        ps.setInt(5, id);
        ps.executeUpdate();
        System.out.println("Data Updated!");
    }
}
