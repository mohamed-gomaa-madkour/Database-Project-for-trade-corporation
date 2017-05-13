package sample.ui.Vendor_Tab.ViewVendor;
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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewVendor_controller implements Initializable{
    ObservableList<Vendor> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Vendor> tableView;

    @FXML
    private TableColumn<Vendor, Integer> vID;

    @FXML
    private TableColumn<Vendor, String> name;

    @FXML
    private TableColumn<Vendor, String> address;

    @FXML
    private TableColumn<Vendor, Integer> phone;

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
        vID.setCellValueFactory(new PropertyValueFactory<>("vID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));


    }
    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `vendor`");
        rs = ps.executeQuery();
        try
        {

            while(rs.next()){
                int vID = rs.getInt(1);
                String name = rs.getString(2);
                int phone = rs.getInt(3);
                String address = rs.getString(4);
                list.add(new Vendor(vID, name, address, phone));

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



    public static class Vendor {

        private final SimpleIntegerProperty vID;
        private final SimpleStringProperty name;
        private final SimpleIntegerProperty phone;
        private final SimpleStringProperty address;



        public Vendor(int vID, String name, String address, int phone) {
            this.vID = new SimpleIntegerProperty(vID);
            this.name = new SimpleStringProperty(name);
            this.phone = new SimpleIntegerProperty(phone);
            this.address = new SimpleStringProperty(address);



        }

        public String getName() {
            return name.get();
        }

        public int getVID() {
            return vID.get();
        }
        public String getAddress() {
            return address.get();
        }

        public int getPhone() {
            return phone.get();
        }



    }


}
