package sample.ui.Employee_Tab.ViewEmployee;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ui.Department_Tab.ViewDepartments.*;

import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.util.ResourceBundle;

public class ViewEmployee_controller implements Initializable {
    ObservableList<Employee> list = FXCollections.observableArrayList();


    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> first_name;

    @FXML
    private TableColumn<Employee, String> last_name;

    @FXML
    private TableColumn<Employee, Integer> ssn;

    @FXML
    private TableColumn<Employee, String> job;

    @FXML
    private TableColumn<Employee, Integer> salary;

    @FXML
    private TableColumn<Employee, Integer> age;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableColumn<Employee, Integer> phone;

    @FXML
    private TableColumn<Employee, Date> birth_date;

    @FXML
    private JFXButton cancle;


    @FXML
    private TableColumn<Employee, Integer> dept_ID;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initCol() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("fname"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("lname"));
        ssn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        birth_date.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        dept_ID.setCellValueFactory(new PropertyValueFactory<>("dId"));




    }
    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `employee`");
        rs = ps.executeQuery();
        try
        {

            while(rs.next()){
                int id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                int ssn = rs.getInt(4);
                String job = rs.getString(5);
                int salary = rs.getInt(6);
                int age = rs.getInt(7);
                String address = rs.getString(8);
                int phone = rs.getInt(9);
                String birthdate = rs.getDate(10) +"";
                int dID = rs.getInt(11);

                list.add(new Employee(id, fname, lname, ssn, job, salary, age, address, phone, birthdate, dID));

            }


        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
        finally {
            if (rs != null) {
                rs.close();
            }

        }
        employeeTable.getItems().setAll(list);

    }



    public static class Employee {

        private final SimpleIntegerProperty id;
        private final SimpleStringProperty fname;
        private final SimpleStringProperty lname;
        private final SimpleIntegerProperty ssn;
        private final SimpleStringProperty job;
        private final SimpleIntegerProperty salary;
        private final SimpleIntegerProperty age;
        private final SimpleStringProperty address;
        private final SimpleIntegerProperty phone;
        private final SimpleStringProperty birthdate;
        private final SimpleIntegerProperty dId;


        public Employee(int id, String fname, String lname, int ssn, String job, int salary, int age, String address, int phone, String birthdate, int dId) {
            this.id = new SimpleIntegerProperty(id);
            this.lname = new SimpleStringProperty(lname);
            this.fname = new SimpleStringProperty(fname);
            this.ssn = new SimpleIntegerProperty(ssn);
            this.job = new SimpleStringProperty(job);
            this.salary = new SimpleIntegerProperty(salary);
            this.age = new SimpleIntegerProperty(age);
            this.address = new SimpleStringProperty(address);
            this.phone = new SimpleIntegerProperty(phone);
            this.birthdate = new SimpleStringProperty(birthdate);
            this.dId = new SimpleIntegerProperty(dId);








        }



        public int getId() {
            return id.get();
        }
        public String getLname() {
            return lname.get();
        }
        public String getFname() {
            return fname.get();
        }

        public int getSsn() {
            return ssn.get();
        }
        public String getJob() {
            return job.get();
        }

        public int getSalary() {
            return salary.get();
        }
        public String getAddress() {
            return address.get();
        }

        public int getAge() {
            return age.get();
        }
        public int getPhone() {
            return phone.get();
        }
        public String getBirthdate() {
            return birthdate.get();
        }

        public int getDId() {
            return dId.get();
        }

    }
}


