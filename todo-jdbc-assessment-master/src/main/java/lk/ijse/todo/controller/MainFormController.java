package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 2:56 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    @FXML
    private AnchorPane root;

    public void initialize() throws IOException {
        initializeDashboard();
    }

    private void initializeDashboard() throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        initializeDashboard();
    }

    @FXML
    void btnAddTaskOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/add_task_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    @FXML
    void btnDueTaskOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/due_task_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    @FXML
    void btnCompletedTaskOnAction(ActionEvent event) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/completed_task_form.fxml"));

        this.root.getChildren().clear();
        this.root.getChildren().add(node);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Login");
    }
}
