package sample.ui.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class SearchHandler {
    private static String username = "root";
    private static String password = null;
    private static String con_string = "jdbc:mysql://localhost/mall";

    public static Connection connDB() throws SQLException {
        return DriverManager.getConnection(con_string, username, password);
    }
}
