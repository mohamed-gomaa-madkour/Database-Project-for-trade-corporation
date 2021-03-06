package sample.ui.Employee_Tab.AddEmployee;
import java.sql.*;


public class addHandler {

    public static Connection connDB() throws SQLException {
        String username = "root";
        String password = null;
        String con_string = "jdbc:mysql://localhost/mall";
        return DriverManager.getConnection(con_string, username, password);
    }

    public static void createConnection(int id, String fname, String lname, int ssn, String job, int salary, int age, String address, int phone, Date birthdate, int departmentID) throws SQLException {

        try (
                Connection conn = connDB();) {
            preparedUpdate(conn,  id,  fname,  lname,  ssn,  job,  salary,  age,  address,  phone,  birthdate,  departmentID);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
    }
    private static void preparedUpdate(final Connection conn, int id, String fname, String lname, int ssn, String job, int salary, int age, String address, int phone, Date birthdate, int departmentID) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `employee`(`id`, `fname`, `lname`, `ssn`, `job`, `salary`, `age`, `address`, `phone`, `birthdate`, `departmentID`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setInt(4,ssn);
        ps.setString(5, job);
        ps.setInt(6, salary);
        ps.setInt(7, age);
        ps.setString(8, address);
        ps.setInt(9, phone);
        ps.setDate(10, birthdate);
        ps.setInt(11, departmentID);

        ps.executeUpdate();
        System.out.println("Data Inserted!");
    }
}
