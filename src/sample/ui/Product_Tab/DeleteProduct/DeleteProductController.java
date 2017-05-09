package sample.ui.Product_Tab.DeleteProduct;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class DeleteProductController {

    @FXML
    private JFXButton delete;

    @FXML
    private JFXButton cancle;

    @FXML
    private Label type;

    @FXML
    private JFXTextField enter_serial;

    @FXML
    private Label model;

    @FXML
    private Label p_price;

    @FXML
    private Label s_price;

    deleteHandler db;
    @FXML
    void deleteProduct(ActionEvent event) throws SQLException {
        int serial = Integer.parseInt(enter_serial.getText());

        db.createConnection(serial);
    }

}
