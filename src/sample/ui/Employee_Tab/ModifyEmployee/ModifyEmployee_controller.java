package sample.ui.Employee_Tab.ModifyEmployee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ModifyEmployee_controller {


    @FXML
    private Label Ename;

    @FXML
    private JFXTextField enter_Eid;

    @FXML
    private JFXTextField new_1st_name;

    @FXML
    private JFXTextField new_last_name;

    @FXML
    private JFXTextField new_ssn;

    @FXML
    private JFXTextField new_salary;

    @FXML
    private JFXTextField new_age;

    @FXML
    private JFXTextField new_bdate;

    @FXML
    private JFXTextField new_address;

    @FXML
    private JFXTextField new_job;

    @FXML
    private JFXTextField new_phone;

    @FXML
    private JFXTextField new_Eid;

    @FXML
    private JFXButton modifyE;

    @FXML
    private JFXButton cancleE;
    @FXML
    private JFXTextField new_DID;

    modifyHandler db;
    @FXML
    void modifyEmployee(ActionEvent event) throws SQLException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        int e_id = Integer.parseInt(new_Eid.getText());
        String fname = new_1st_name.getText();
        String lname = new_last_name.getText();
        int e_ssn = Integer.parseInt(new_ssn.getText());
        String e_job =new_job.getText();
        int e_salary = Integer.parseInt(new_salary.getText());
        int e_age = Integer.parseInt(new_age.getText());
        String e_address = new_address.getText();
        int e_phone = Integer.parseInt(new_phone.getText());
        Date e_date = java.sql.Date.valueOf(LocalDate.parse(new_bdate.getText(), formatter));
        int d_id = Integer.parseInt(new_DID.getText());
        int old_id = Integer.parseInt(enter_Eid.getText());

        db.createConnection(e_id,fname,lname,e_ssn,e_job,e_salary,e_age,e_address,e_phone,e_date,d_id,old_id);
    }
}
