package sample.ui.Department_Tab.ViewDepartments;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class ViewDepartmentsController implements Initializable {
    ObservableList<Department> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Department> tableView;
    @FXML
    private TableColumn<Department, Integer> id_column;

    @FXML
    private TableColumn<Department, String> name_column;

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

    }
    private void loadData() throws SQLException {
        ViewHandler vh = null;
        ResultSet rs = null;
        Connection conn = vh.connDB();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM `department`");
        rs = ps.executeQuery();
        try
               {

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Department(id, name));

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



    public static class Department {

        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;


        public Department(int id, String name) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);

        }

        public String getName() {
            return name.get();
        }

        public int getId() {
            return id.get();
        }


    }
}

