package sample.ui.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.ui.main.MainController;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MOHAM on 01/05/2017.
 */
public class LoginController {
    @FXML
    private Button connect_btn;

    @FXML
    void connect(ActionEvent event) {
        loadWindow("/sample/ui/main/Main.fxml", "The Mall");

    }



    void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
