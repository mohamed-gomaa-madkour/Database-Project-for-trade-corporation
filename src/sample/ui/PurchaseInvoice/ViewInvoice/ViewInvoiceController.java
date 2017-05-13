package sample.ui.PurchaseInvoice.ViewInvoice;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewInvoiceController implements Initializable {
    ObservableList<Purchase> list = FXCollections.observableArrayList();


    @FXML
    private TableView<Purchase> tableView;

    @FXML
    private TableColumn<Purchase, Integer> serial;

    @FXML
    private TableColumn<Purchase, Date> date;

    @FXML
    private TableColumn<Purchase, Integer> items;

    @FXML
    private TableColumn<Purchase, Integer> total;
    @FXML
    private TableColumn<Purchase, Integer> vendor;
    @FXML
    private TableColumn<Purchase, Integer> employee;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initCol() {
        serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        items.setCellValueFactory(new PropertyValueFactory<>("items"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        vendor.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        employee.setCellValueFactory(new PropertyValueFactory<>("employee"));

    }

    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `purchaseinvoice`");
        rs = ps.executeQuery();
        try {

            while (rs.next()) {
                int serial = rs.getInt(1);
                String date = rs.getDate(2) + "";
                int items = rs.getInt(3);
                int total = rs.getInt(4);
                int vendor = rs.getInt(5);
                int employee = rs.getInt(6);
                list.add(new Purchase(serial, date, items, total, vendor, employee));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        } finally {
            if (rs != null) {
                rs.close();
            }

        }
        tableView.getItems().setAll(list);

    }

    public static class Purchase {

        private final SimpleIntegerProperty serial;
        private final SimpleStringProperty date;
        private final SimpleIntegerProperty items;
        private final SimpleIntegerProperty total;
        private final SimpleIntegerProperty vendor;
        private final SimpleIntegerProperty employee;

        public Purchase(int serial, String date, int items, int total, int vendor, int employee) {
            this.serial = new SimpleIntegerProperty(serial);
            this.date = new SimpleStringProperty(date);
            this.items = new SimpleIntegerProperty(items);
            this.total = new SimpleIntegerProperty(total);
            this.vendor = new SimpleIntegerProperty(vendor);
            this.employee = new SimpleIntegerProperty(employee);
        }
        public int getSerial() {
            return serial.get();
        }
        public String getDate() {
            return date.get();
        }
        public int getItems() {
            return items.get();
        }
        public int getTotal() {
            return total.get();
        }
        public int getVendor() {
            return vendor.get();
        }
        public int getEmployee() {
            return employee.get();
        }

    }
}
