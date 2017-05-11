package sample.ui.Vendor_Tab.ModifyVendor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class ModifyVendor_controller {

    @FXML
    private Label Vname;

    @FXML
    private JFXTextField enter_Vid;

    @FXML
    private JFXTextField new_Vname;

    @FXML
    private JFXTextField new_Vaddress;

    @FXML
    private JFXTextField new_Vphone;

    @FXML
    private JFXButton modifyV;

    @FXML
    private JFXButton cancleV;
    @FXML
    private JFXTextField new_VID;

    modifyHandler db;
    @FXML
    void modifyVendor(ActionEvent event) throws SQLException {
        int vendor_id = Integer.parseInt(new_VID.getText());
        String vendor_name = new_Vname.getText();
        int vendor_phone = Integer.parseInt(new_Vphone.getText());
        String vendor_address = new_Vaddress.getText();
        int v_id = Integer.parseInt(enter_Vid.getText());

        db.createConnection(vendor_id , vendor_name, vendor_phone, vendor_address, v_id);
    }

}
