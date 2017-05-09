package sample.ui.Department_Tab.AddDepartment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class AddDepartmentController {

    @FXML
    private JFXTextField d_id;

    @FXML
    private JFXTextField d_name;

    @FXML
    private JFXButton d_save;

    @FXML
    private JFXButton d_cancle;

    addHandler db;
    @FXML
    void addDepartment(ActionEvent event) throws SQLException {
        int dept_id = Integer.parseInt(d_id.getText());
        String dept_name = d_name.getText();

        db.createConnection(dept_id,dept_name);
    }

}
