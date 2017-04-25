package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    @FXML
    void loadAddInvoice() {
        loadWindow("/sample/PurchaseInvoice/AddInvoice/AddInvoice1.fxml");

    }

    private void loadWindow(String s) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(s));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void loadAddInvoice1() {
        loadWindow("/sample/SalesInvoice/AddInvoice/AddInvoice1.fxml");
    }

    @FXML
    void loadDeleteInvoice() {
        loadWindow("/sample/PurchaseInvoice/DeleteInvoice/DeleteInvoice1.fxml");
    }

    @FXML
    void loadDeleteInvoice1() {
        loadWindow("/sample/SalesInvoice/DeleteInvoice/DeleteInvoice1.fxml");

    }

    @FXML
    void loadModifyInvoice() {
        loadWindow("/sample/PurchaseInvoice/ModifyInvoice/ModifyInvoice1.fxml");

    }

    @FXML
    void loadModifyInvoice1() {
        loadWindow("/sample/SalesInvoice/ModifyInvoice/ModifyInvoice1.fxml");
    }

    @FXML
    void loadViewInvoices() {
        loadWindow("/sample/PurchaseInvoice/ViewInvoice/ViewInvoice.fxml");
    }

    @FXML
    void loadViewInvoices1() {
        loadWindow("/sample/SalesInvoice/ViewInvoice/ViewInvoice.fxml");
    }
}
