package lk.ijse.todo;

/*
    @author DanujaV
    @created 11/7/23 - 12:08 AM   
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.centerOnScreen();

        stage.show();
    }
}
