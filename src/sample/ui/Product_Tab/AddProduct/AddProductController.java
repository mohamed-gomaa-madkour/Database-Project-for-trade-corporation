package sample.ui.Product_Tab.AddProduct;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class AddProductController {

    @FXML
    private JFXTextField serial;

    @FXML
    private JFXTextField type;

    @FXML
    private JFXTextField model;

    @FXML
    private JFXTextField p_price;

    @FXML
    private JFXTextField s_price;

    @FXML
    private JFXTextField d_id;

    @FXML
    private JFXTextField purchase_serial;

    @FXML
    private JFXTextField vendor;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton cancle;

    addHandler db;
    @FXML
    void addProduct(ActionEvent event) throws SQLException {
        int p_serial = Integer.parseInt(serial.getText());
        String p_type = type.getText();
        String p_model = model.getText();
        int purchase_price = Integer.parseInt(p_price.getText());
        int sales_price = Integer.parseInt(s_price.getText());
        int department_id = Integer.parseInt(d_id.getText());
        int purch_serial = Integer.parseInt(purchase_serial.getText());
        int vendor_id = Integer.parseInt(vendor.getText());

        db.createConnection(p_serial,p_type,p_model,purchase_price,sales_price,department_id,purch_serial,vendor_id);
    }

}
