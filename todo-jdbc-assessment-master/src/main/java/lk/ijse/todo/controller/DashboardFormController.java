package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 2:51 AM   
*/

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lk.ijse.todo.model.TaskModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    @FXML
    private Label lblCompleted;

    @FXML
    private Label lblDue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCount();
    }

    private void setCount() {
        try {
            lblCompleted.setText(TaskModel.getCompiled());
            lblDue.setText(TaskModel.getAllTask());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
