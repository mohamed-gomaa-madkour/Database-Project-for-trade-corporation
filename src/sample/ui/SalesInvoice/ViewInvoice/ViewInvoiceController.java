package sample.ui.SalesInvoice.ViewInvoice;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
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
    private TableColumn<Purchase, Integer> customer;
    @FXML
    private TableColumn<Purchase, Integer> employee;
    @FXML
    private TableColumn<Purchase, Integer> product;

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
        customer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        employee.setCellValueFactory(new PropertyValueFactory<>("employee"));
        product.setCellValueFactory(new PropertyValueFactory<>("product"));


    }

    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `sales_invoice`");
        rs = ps.executeQuery();
        try {

            while (rs.next()) {
                int serial = rs.getInt(1);
                String date = rs.getDate(2) + "";
                int items = rs.getInt(3);
                int total = rs.getInt(4);
                int customer = rs.getInt(5);
                int employee = rs.getInt(6);
                int product = rs.getInt(7);
                list.add(new Purchase(serial, date, items, total, customer, employee, product));
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
        private final SimpleIntegerProperty customer;
        private final SimpleIntegerProperty employee;
        private final SimpleIntegerProperty product;


        public Purchase(int serial, String date, int items, int total, int customer, int employee, int product) {
            this.serial = new SimpleIntegerProperty(serial);
            this.date = new SimpleStringProperty(date);
            this.items = new SimpleIntegerProperty(items);
            this.total = new SimpleIntegerProperty(total);
            this.customer = new SimpleIntegerProperty(customer);
            this.employee = new SimpleIntegerProperty(employee);
            this.product = new SimpleIntegerProperty(product);

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
        public int getCustomer() {
            return customer.get();
        }
        public int getEmployee() {
            return employee.get();
        }
        public int getProduct() {
            return product.get();
        }


    }
}
