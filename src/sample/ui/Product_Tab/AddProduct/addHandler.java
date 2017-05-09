package sample.ui.Product_Tab.AddProduct;
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

    public static void createConnection(int serial, String p_type, String model, int purchase_price, int sales_price, int d_id, int purchase_serial, int vendor_id) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, serial, p_type, model, purchase_price,  sales_price,  d_id, purchase_serial,  vendor_id);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int serial, String p_type, String model, int purchase_price, int sales_price,  int d_id, int purchase_serial, int vendor_id ) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `product`(`serial`, `p_type`, `model`, `purchase_price`, `sales_price`, `dept_id`, `purchase_serial`, `vendor_id`) VALUES (?,?,?,?,?,?,?,?)");

        ps.setInt(1, serial);
        ps.setString(2, p_type);
        ps.setString(3, model);
        ps.setInt(4, purchase_price);
        ps.setInt(5, sales_price);
        ps.setInt(6, d_id);
        ps.setInt(7, purchase_serial);
        ps.setInt(8,vendor_id);

        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
