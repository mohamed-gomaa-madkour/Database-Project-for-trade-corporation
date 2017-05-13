package sample.ui.PurchaseInvoice.DeleteInvoice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class DeleteInvoiceController {

    @FXML
    private JFXTextField serialNo;

    @FXML
    private JFXButton delbutton;

    @FXML
    private JFXButton cancelbutton;

    @FXML
    void cancel() {

    }
    deleteHandler db;
    @FXML
    void delete() throws SQLException {
        int serial = Integer.parseInt(serialNo.getText());

        db.createConnection(serial);
    }

}