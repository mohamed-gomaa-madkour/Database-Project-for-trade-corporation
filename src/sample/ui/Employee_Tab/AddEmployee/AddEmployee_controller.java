package sample.ui.Employee_Tab.AddEmployee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class AddEmployee_controller {

    @FXML
    private JFXTextField first_name;

    @FXML
    private JFXTextField last_name;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField ssn;

    @FXML
    private JFXTextField salary;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField job;

    @FXML
    private JFXTextField department_id;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField birth_day;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;

    addHandler db;
    @FXML
    void addEmployee(ActionEvent event) throws SQLException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        int e_id = Integer.parseInt(id.getText());
        String fname = first_name.getText();
        String lname = last_name.getText();
        int e_ssn = Integer.parseInt(ssn.getText());
        String e_job =job.getText();
        int e_salary = Integer.parseInt(salary.getText());
        int e_age = Integer.parseInt(age.getText());
        String e_address = address.getText();
        int e_phone = Integer.parseInt(phone.getText());
        Date e_date = java.sql.Date.valueOf(LocalDate.parse(birth_day.getText(), formatter));
        int d_id = Integer.parseInt(department_id.getText());


        db.createConnection(e_id,fname,lname,e_ssn,e_job,e_salary,e_age,e_address,e_phone,e_date,d_id);
    }

}