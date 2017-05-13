package sample.ui.Customer_Tab.ViewCustomers;

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
import sample.ui.Department_Tab.ViewDepartments.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCustomersController implements Initializable {
    ObservableList<Customer> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, Integer> id_column;

    @FXML
    private TableColumn<Customer, String> name_column;

    @FXML
    private TableColumn<Customer, Integer> phone_column;

    @FXML
    private JFXButton cancle;

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
        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));


    }
    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `customer`");
        rs = ps.executeQuery();
        try
        {

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int phone = rs.getInt(3);
                list.add(new Customer(id, name, phone));

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



    public static class Customer {

        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;
        private final SimpleIntegerProperty phone;



        public Customer(int id, String name,  int phone) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.phone = new SimpleIntegerProperty(phone);


        }

        public String getName() {
            return name.get();
        }

        public int getId() {
            return id.get();
        }
        public int getPhone() {
            return phone.get();
        }


    }
}
