package sample.ui.SalesInvoice.ModifyInvoice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModifyInvoiceMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ModifyInvoice1.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Modify Invoice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}