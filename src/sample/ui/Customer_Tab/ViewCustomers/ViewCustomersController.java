package ui.Customer_Tab.ViewCustomers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ViewCustomersController {

    @FXML
    private TableColumn<?, ?> id_column;

    @FXML
    private TableColumn<?, ?> name_column;

    @FXML
    private TableColumn<?, ?> phone_column;

    @FXML
    private JFXButton cancle;

}
