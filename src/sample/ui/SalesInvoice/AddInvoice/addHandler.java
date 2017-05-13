package sample.ui.SalesInvoice.AddInvoice;
import java.sql.*;


public class addHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int serial, Date date, int items, int totalPrice,int customerID, int employeeID, int productSerial) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, serial, date, items, totalPrice,  customerID,  employeeID, productSerial);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int serial, Date date, int items, int totalPrice, int customerID, int employeeID, int productSerial) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `sales_invoice`(`serial`, `date`, `no_items`, `totalPrice`, `customerID`, `employeeID`, `productSerial`) VALUES (?,?,?,?,?,?,?)");

        ps.setInt(1, serial);
        ps.setDate(2, date);
        ps.setInt(3, items);
        ps.setInt(4, totalPrice);
        ps.setInt(5, customerID);
        ps.setInt(6, employeeID);
        ps.setInt(7, productSerial);


        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
