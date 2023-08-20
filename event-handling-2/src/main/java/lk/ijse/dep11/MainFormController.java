package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class MainFormController {
    public AnchorPane root;
    public TextField txtInput;
    public Button btnAdd;
    public ListView<String> lvItems;
    public Button btnRemove;
    public Label lblCount;

    // listView, comboBox,Table
    public void initialize(){

        lblCount.setText("Count: 0");
        btnAdd.setDefaultButton(true);
        btnRemove.setDisable(true);

        // ListView, ComboBox, TableView
        lvItems.getSelectionModel().selectedItemProperty().addListener((value,prev,current) ->{
            System.out.printf("previous = %s, current = %s\n",prev,current);
            /*
            To disable a control => setDisable(true)
            To enable a control => setDisable(false)
             */
            btnRemove.setDisable(current == null);  // to activate = false, to disable = true
        });
    }
    public void btnAddOnAction(ActionEvent e) {
        String text = txtInput.getText().strip();
        if(text.isBlank()) {
            txtInput.requestFocus();
            txtInput.selectAll();
            return;
        }
        lvItems.getItems().add(text);
        lblCount.setText("Count: "+lvItems.getItems().size());
        txtInput.clear();
        txtInput.requestFocus();
    }

    public void lvItemsOnKeyPressed(KeyEvent e) {
        System.out.println(e.getCode());
        if(e.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void btnRemoveOnAction(ActionEvent e) {
        int selectedIndex = lvItems.getSelectionModel().getSelectedIndex();
        lvItems.getItems().remove(selectedIndex);
        lblCount.setText("Count: "+lvItems.getItems().size());
        lvItems.getSelectionModel().clearSelection();
    }
}
