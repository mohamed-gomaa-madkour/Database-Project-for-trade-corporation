package sample.ui.Product_Tab.ModifyProduct;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class ModifyProductController {


    @FXML
    private Label type;

    @FXML
    private JFXTextField enter_serial;

    @FXML
    private JFXTextField new_serial;

    @FXML
    private JFXTextField new_ppric;

    @FXML
    private Label model;

    @FXML
    private JFXTextField new_sprice;

    @FXML
    private Label p_price;

    @FXML
    private Label s_price;

    @FXML
    private JFXTextField new_model;

    @FXML
    private JFXTextField new_type;

    @FXML
    private JFXTextField new_dept;

    @FXML
    private JFXTextField newPurSerial;

    @FXML
    private JFXTextField newVendor;

    @FXML
    private JFXButton modify;

    @FXML
    private JFXButton cancle;

    modifyHandler db;
    @FXML
    void modifyProduct(ActionEvent event) throws SQLException {
        int p_serial = Integer.parseInt(new_serial.getText());
        String p_type = new_type.getText();
        String p_model = new_model.getText();
        int purchase_price = Integer.parseInt(new_ppric.getText());
        int sales_price = Integer.parseInt(new_sprice.getText());
        int department_id = Integer.parseInt(new_dept.getText());
        int purch_serial = Integer.parseInt(newPurSerial.getText());
        int vendor_id = Integer.parseInt(newVendor.getText());
        int pid = Integer.parseInt(enter_serial.getText());

        db.createConnection(p_serial,p_type,p_model,purchase_price,sales_price,department_id,purch_serial,vendor_id, pid);
    }
}
