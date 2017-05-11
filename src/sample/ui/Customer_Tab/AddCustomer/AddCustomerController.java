package sample.ui.Customer_Tab.AddCustomer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class AddCustomerController {

    @FXML
    private JFXTextField c_id;

    @FXML
    private JFXTextField c_name;

    @FXML
    private JFXTextField c_phone;

    @FXML
    private JFXButton c_save;

    @FXML
    private JFXButton cancle;

    addHandler db;

    @FXML
    void addCustomer(ActionEvent event) throws SQLException {
        int n_id = Integer.parseInt(c_id.getText());
        String n_name = c_name.getText();
        int n_phone = Integer.parseInt(c_phone.getText());

        db.createConnection(n_id,n_name,n_phone);
    }

}


