package sample.ui.Department_Tab.ModifyDepartment;
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

    public static void createConnection(int D_ID, String D_name, int id) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn, D_ID, D_name, id);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int D_ID, String D_name, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE `department` SET `D_ID`=?,`D_name`=? WHERE `D_ID` = ?");

        ps.setInt(1, D_ID);
        ps.setString(2, D_name);
        ps.setInt(3, id);
        ps.executeUpdate();
        System.out.println("Data Updated!");
    }
}
