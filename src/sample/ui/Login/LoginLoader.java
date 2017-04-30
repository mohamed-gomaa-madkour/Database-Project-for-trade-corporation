package sample.ui.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by MOHAM on 01/05/2017.
 */
public class LoginLoader extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("The Mall");
        primaryStage.setScene(new Scene(root, 573, 356));
        primaryStage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
