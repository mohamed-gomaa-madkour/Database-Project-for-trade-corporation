package sample.ui.Department_Tab.ModifyDepartment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class ModifyDepartmentController {

    @FXML
    private Label dname;

    @FXML
    private JFXTextField enter_id;

    @FXML
    private JFXTextField new_id;

    @FXML
    private JFXTextField new_name;

    @FXML
    private JFXButton modify;

    @FXML
    private JFXButton cancle;

    modifyHandler db;

    @FXML
    void modifyDepartment(ActionEvent event) throws SQLException {
        int dept_id = Integer.parseInt(new_id.getText());
        String dept_name = new_name.getText();
        int d_id = Integer.parseInt(enter_id.getText());

        db.createConnection(dept_id , dept_name, d_id);
    }
}
