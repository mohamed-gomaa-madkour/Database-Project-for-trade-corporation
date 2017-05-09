package sample.ui.Customer_Tab.DeleteCustomer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DeleteCustomerController {


    @FXML
    private JFXButton c_delete;

    @FXML
    private JFXButton ccancle;

    @FXML
    private Label cname;

    @FXML
    private JFXTextField enter_id;

    @FXML
    private Label cphone;

    deleteHandler db;

    @FXML
    void deleteCustomer(ActionEvent event) throws SQLException {
        int n_id = Integer.parseInt(enter_id.getText());

        db.createConnection(n_id);
    }

}
