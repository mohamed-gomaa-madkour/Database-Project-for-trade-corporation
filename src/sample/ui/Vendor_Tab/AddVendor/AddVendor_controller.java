package sample.ui.Vendor_Tab.AddVendor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class AddVendor_controller {


    @FXML
    private JFXTextField v_name;

    @FXML
    private JFXTextField v_address;

    @FXML
    private JFXTextField v_phone;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton cancelButton;
    @FXML
    private JFXTextField v_ID;

    addHandler db;

    @FXML
    void addVendor(ActionEvent event) throws SQLException {
        int vendor_id = Integer.parseInt(v_ID.getText());
        String vendor_name = v_name.getText();
        int vendor_phone = Integer.parseInt(v_phone.getText());
        String vendor_address = v_address.getText();

        db.createConnection(vendor_id,vendor_name,vendor_phone,vendor_address);
    }



}
