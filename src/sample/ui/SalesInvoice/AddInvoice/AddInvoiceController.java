package sample.ui.SalesInvoice.AddInvoice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AddInvoiceController {

    @FXML
    private JFXTextField serialNo;

    @FXML
    private JFXTextField date;

    @FXML
    private JFXTextField items;

    @FXML
    private JFXTextField totPrice;

    @FXML
    private JFXTextField custid;

    @FXML
    private JFXTextField eid;

    @FXML
    private JFXTextField productSerial;

    @FXML
    private JFXButton addbutton;

    @FXML
    private JFXButton cancelbutton;
    addHandler db;
    @FXML
    void add() throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        int serial = Integer.parseInt(serialNo.getText());
        Date e_date = java.sql.Date.valueOf(LocalDate.parse(date.getText(), formatter));
        int n_items = Integer.parseInt(items.getText());
        int total = Integer.parseInt(totPrice.getText());
        int custId = Integer.parseInt(custid.getText());
        int employeeId = Integer.parseInt(eid.getText());
        int pserial = Integer.parseInt(productSerial.getText());

        db.createConnection(serial,e_date,n_items,total,custId,employeeId, pserial);

    }

    @FXML
    void cancel() {

    }

}

