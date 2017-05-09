package sample.ui.Customer_Tab.ModifyCustomer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class ModifyCustomerController {

    @FXML
    private Label cname;

    @FXML
    private JFXTextField enter_id;

    @FXML
    private JFXTextField new_id;

    @FXML
    private JFXTextField new_name;

    @FXML
    private Label cphone;

    @FXML
    private JFXTextField new_phone;

    @FXML
    private JFXButton modify;

    @FXML
    private JFXButton cancle;

    modifyHandler db;

    @FXML
    void modifyCustomer(ActionEvent event) throws SQLException {
        int n_id = Integer.parseInt(new_id.getText());
        String n_name = new_name.getText();
        int n_phone = Integer.parseInt(new_phone.getText());
        int e_id = Integer.parseInt(enter_id.getText());

        db.createConnection(n_id,n_name,n_phone,e_id);
    }
}

