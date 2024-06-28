package com.justiceasare.gtptextprocessing.controllers;

import com.justiceasare.gtptextprocessing.models.DataModel;
import com.justiceasare.gtptextprocessing.models.DialogManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MainController {
    @FXML
    private TableView<DataModel> dataTable;
    @FXML
    private TableColumn<DataModel, String> dataColumn;

    private final ObservableList<DataModel> dataList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        dataTable.setItems(dataList);
        dataTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void addData(DataModel dataModel) {
        dataList.add(dataModel);
    }

    public void updateData(DataModel oldData, DataModel newData) {
        int index = dataList.indexOf(oldData);
        if (index >= 0) {
            dataList.set(index, newData);
        }
    }

    public void deleteData(DataModel dataModel) {
        dataList.remove(dataModel);
    }

    @FXML
    private void handleAdd() {
        DialogManager.showAddDialog();
    }

    @FXML
    private void handleUpdate() {
        DataModel selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            DialogManager.showUpdateDialog(selectedItem);
        }
    }

    @FXML
    private void handleDelete() {
        DataModel selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            DialogManager.showDeleteDialog(selectedItem);
        }
    }

    @FXML
    private void handleSearch() {
        DataModel selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            DialogManager.showSearchDialog(selectedItem.getData());
        }
    }

    @FXML
    private void handleReplace() {
        DataModel selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String updatedText = DialogManager.showReplaceDialog(selectedItem.getData());
            if (updatedText != null && !updatedText.isEmpty()) {
                selectedItem.setData(updatedText);
                dataTable.refresh();
            }
        }
    }

    @FXML
    private void handleMatch() {
        DataModel selectedItem = dataTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            DialogManager.showMatchDialog(selectedItem.getData());
        }
    }
}