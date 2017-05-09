package sample.ui.Department_Tab.DeleteDepartment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DeleteDepartmentController {

    @FXML
    private JFXButton d_delete;

    @FXML
    private JFXButton dcancle;

    @FXML
    private Label dname;

    @FXML
    private JFXTextField enter_id;

    deleteHandler db;
    @FXML
    void deleteDepartment(ActionEvent event) throws SQLException {
        int d_id = Integer.parseInt(enter_id.getText());

        db.createConnection(d_id);
    }

}
