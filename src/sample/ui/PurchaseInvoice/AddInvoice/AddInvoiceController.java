package sample.ui.PurchaseInvoice.AddInvoice;

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
    private JFXTextField dat;

    @FXML
    private JFXTextField items;

    @FXML
    private JFXTextField totpric;

    @FXML
    private JFXTextField vid;

    @FXML
    private JFXTextField eid;

    @FXML
    private JFXButton addbutton;

    @FXML
    private JFXButton cancelbutton;
    addHandler db;
    @FXML
    void add() throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        int serial = Integer.parseInt(serialNo.getText());
        Date e_date = java.sql.Date.valueOf(LocalDate.parse(dat.getText(), formatter));
        int n_items = Integer.parseInt(items.getText());
        int total = Integer.parseInt(totpric.getText());
        int vendorId = Integer.parseInt(vid.getText());
        int employeeId = Integer.parseInt(eid.getText());
        db.createConnection(serial,e_date,n_items,total,vendorId,employeeId);

    }

    @FXML
    void cancel() {

    }

}
