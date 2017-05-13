package sample.ui.Product_Tab.ViewProducts;

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
import sample.ui.Department_Tab.ViewDepartments.ViewDepartmentsController;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewProductsController implements Initializable {
        ObservableList<Product> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> tableView;
        @FXML
        private JFXButton cancle;

        @FXML
        private TableColumn<Product, Integer> serial;

        @FXML
        private TableColumn<Product, String> type;

        @FXML
        private TableColumn<Product, Product> model;

        @FXML
        private TableColumn<Product, Integer> p_price;

        @FXML
        private TableColumn<Product, Integer> s_price;
        @FXML
        private TableColumn<Product, Integer> dept_id;
        @FXML
        private TableColumn<Product, Integer> p_serial;
        @FXML
        private TableColumn<Product, Integer> vendor;

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
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        p_price.setCellValueFactory(new PropertyValueFactory<>("p_price"));
        s_price.setCellValueFactory(new PropertyValueFactory<>("s_price"));
        dept_id.setCellValueFactory(new PropertyValueFactory<>("dept_id"));
        p_serial.setCellValueFactory(new PropertyValueFactory<>("p_serial"));
        vendor.setCellValueFactory(new PropertyValueFactory<>("vendor"));



    }
    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `product`");
        rs = ps.executeQuery();
        try
        {

            while(rs.next()){
                int serial = rs.getInt(1);
                String type = rs.getString(2);
                String model = rs.getString(3);
                int p_price = rs.getInt(4);
                int s_price = rs.getInt(5);
                int dept_id = rs.getInt(6);
                int p_serial = rs.getInt(7);
                int vendor = rs.getInt(8);


                list.add(new Product(serial, type, model, p_price, s_price, dept_id, p_serial, vendor));

            }


        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("State: " + e.getSQLState());
            System.err.println("Code: " + e.getErrorCode());
        }
        finally {
            if (rs != null) {
                rs.close();
            }

        }
        tableView.getItems().setAll(list);

    }



    public static class Product {

        private final SimpleIntegerProperty serial;
        private final SimpleStringProperty type;
        private final SimpleStringProperty model;
        private final SimpleIntegerProperty p_price;
        private final SimpleIntegerProperty s_price;
        private final SimpleIntegerProperty dept_id;
        private final SimpleIntegerProperty p_serial;
        private final SimpleIntegerProperty vendor;




        public Product(int serial, String type, String model ,int p_price, int s_price, int dept_id, int p_serial, int vendor) {
            this.serial = new SimpleIntegerProperty(serial);
            this.type = new SimpleStringProperty(type);
            this.model = new SimpleStringProperty(model);
            this.p_price = new SimpleIntegerProperty(p_price);
            this.s_price = new SimpleIntegerProperty(s_price);
            this.dept_id = new SimpleIntegerProperty(dept_id);
            this.p_serial = new SimpleIntegerProperty(p_serial);
            this.vendor = new SimpleIntegerProperty(vendor);



        }

        public String getType() {
            return type.get();
        }
        public String getModel() {
            return model.get();
        }

        public int getSerial() {
            return serial.get();
        }
        public int getP_price() {
            return p_price.get();
        }
        public int getS_price() {
            return s_price.get();
        }
        public int getVendor() {
            return vendor.get();
        }
        public int getP_serial() {
            return p_serial.get();
        }
        public int getDept_id() {
            return dept_id.get();
        }


    }
    }

