package sample.ui.PurchaseInvoice.AddInvoice;
import java.sql.*;


public class addHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int serial, Date date, int items, int totalPrice, int vendorID, int employeeId) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, serial, date, items, totalPrice,  vendorID,  employeeId);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int serial, Date date, int items, int totalPrice, int vendorID, int employeeId ) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `purchaseinvoice`(`serial`, `date`, `items`, `totalPrice`, `vendorID`, `employeeId`) VALUES (?,?,?,?,?,?)");

        ps.setInt(1, serial);
        ps.setDate(2, date);
        ps.setInt(3, items);
        ps.setInt(4, totalPrice);
        ps.setInt(5, vendorID);
        ps.setInt(6, employeeId);

        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
