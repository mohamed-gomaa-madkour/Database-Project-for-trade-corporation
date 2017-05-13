package sample.ui.PurchaseInvoice.DeleteInvoice;
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

    public static void createConnection(int serial) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedDelete(conn, serial);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedDelete(final Connection conn, int serial) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM `purchaseinvoice` WHERE `serial` = ?");

        ps.setInt(1, serial);
        ps.executeUpdate();
        System.out.println("Data deleted!");
    }
}
