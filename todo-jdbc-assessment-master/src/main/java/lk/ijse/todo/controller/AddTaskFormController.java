package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 3:23 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lk.ijse.todo.db.DBConnection;
import lk.ijse.todo.dto.TaskDTO;
import lk.ijse.todo.model.TaskModel;
import lk.ijse.todo.model.UserModel;

import java.sql.SQLException;

public class AddTaskFormController {
    @FXML
    private DatePicker txtDate;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTask_id(Integer.parseInt(txtId.getText()));
        taskDTO.setDescription(txtDescription.getText());
        taskDTO.setDueDate(txtDate.getValue());
        taskDTO.setEmail(DBConnection.email);
        taskDTO.setIsCompleted(0);

        try {
            boolean saved = TaskModel.saveTask(taskDTO);
            if (saved) {
                txtDescription.clear();
                txtId.clear();
                new Alert(Alert.AlertType.CONFIRMATION, "tasks added").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "tasks  not add").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }
}
