package sample.ui.Vendor_Tab.DeleteVendor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DelVendor_controller {

    @FXML
    private JFXButton V_delete;

    @FXML
    private JFXButton V_cancle;

    @FXML
    private Label Vname;

    @FXML
    private JFXTextField enter_Vid;

    deleteHandler db;

    @FXML
    void deleteVendor(ActionEvent event) throws SQLException {
        int vendor_id = Integer.parseInt(enter_Vid.getText());

        db.createConnection(vendor_id);
    }

}
