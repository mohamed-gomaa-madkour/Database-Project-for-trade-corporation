package sample.ui.Employee_Tab.ViewEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ViewHandler {
    private static String username = "root";
    private static String password = null;
    private static String con_string = "jdbc:mysql://localhost/mall";

    public static Connection connDB() throws SQLException {
        return DriverManager.getConnection(con_string, username, password);
    }
}
