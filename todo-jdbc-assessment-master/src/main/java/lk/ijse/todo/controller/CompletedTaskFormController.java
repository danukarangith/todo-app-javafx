package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 3:59 AM   
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.todo.dto.tm.CompleteTm;
import lk.ijse.todo.model.TaskModel;

import java.sql.SQLException;
import java.util.List;

import static lk.ijse.todo.model.TaskModel.getCompiled;

public class CompletedTaskFormController {
    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CompleteTm> tblComplete;

    public void initialize() {
        setCellValueFactory();
        loadCompletedTasks();
    }

    private void loadCompletedTasks() {
        ObservableList<CompleteTm> obList = FXCollections.observableArrayList();

        // here you need to write the code to load the tasks from database table and add them to the obList.
        // this is just a sample data set.

        try {
            List<CompleteTm> list = TaskModel.getCompiledList();
            for (CompleteTm tm : list) {
                obList.add(tm);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
       /* obList.add(new CompleteTm("Give birth day party", "2023-09-10"));
        obList.add(new CompleteTm("Service vehicle", "2022-12-24"));
*/
        for (int i = 0; i < obList.size(); i++) {
            // reason for using a for loop here is to add event handlers to the buttons in the table
            obList.get(i).getBtnDelete().setOnAction(event -> {
                // here you need to write the code to delete the task from FX table and database table as well.
//                System.out.printf("Delete button clicked!");

                try {
                    CompleteTm selectedItem = tblComplete.getSelectionModel().getSelectedItem();
                    try {
                        boolean deleted = TaskModel.delete(selectedItem.getId());
                        if (deleted) {
                            loadCompletedTasks();
                            new Alert(Alert.AlertType.CONFIRMATION, "ok deleted").show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "something wrong").show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                } catch (NullPointerException e) {
                    new Alert(Alert.AlertType.WARNING, "Select the column").show();
                }


            });
        }

        tblComplete.setItems(obList);
    }

    private void setCellValueFactory() {
        colDescription.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("description"));
        colDueDate.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("dueDate"));
        colDelete.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("btnDelete"));
    }
}
