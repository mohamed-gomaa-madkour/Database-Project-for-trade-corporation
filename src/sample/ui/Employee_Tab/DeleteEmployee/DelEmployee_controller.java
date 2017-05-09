package sample.ui.Employee_Tab.DeleteEmployee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DelEmployee_controller {

    @FXML
    private JFXButton E_delete;

    @FXML
    private JFXButton Ecancle;

    @FXML
    private Label Ename;

    @FXML
    private JFXTextField enter_Eid;

    deleteHandler db;
    @FXML
    void deleteEmployee(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(enter_Eid.getText());

        db.createConnection(id);
    }
}
