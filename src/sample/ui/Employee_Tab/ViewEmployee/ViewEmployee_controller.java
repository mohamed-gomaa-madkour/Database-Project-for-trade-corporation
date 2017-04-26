package ui.Employee_Tab.ViewEmployee;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ViewEmployee_controller {

    @FXML
    private TableColumn<?, ?> id_column;

    @FXML
    private TableColumn<?, ?> name_column;

    @FXML
    private TableColumn<?, ?> name_column1;

    @FXML
    private TableColumn<?, ?> name_column2;

    @FXML
    private TableColumn<?, ?> name_column3;

    @FXML
    private TableColumn<?, ?> name_column4;

    @FXML
    private TableColumn<?, ?> name_column5;

    @FXML
    private TableColumn<?, ?> name_column31;

    @FXML
    private TableColumn<?, ?> name_column32;

    @FXML
    private TableColumn<?, ?> name_column33;

    @FXML
    private JFXButton cancle;
    @FXML
    void cancel_viewEmployee(ActionEvent event) {
System.exit(1);

    }

}
