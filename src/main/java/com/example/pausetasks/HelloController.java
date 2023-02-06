package com.example.pausetasks;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public AnchorPane rootPane;
    public HBox hBox;
    public Button btnAddRadio;
    public int btnCtr;
    public String btnName;
    private final Button[] buttons = new Button[10];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCtr = 0;
        hBox.setSpacing(10);
    }

    public void addRadioFunc() {
btnCtr=1;
        for (int i = 0; i < buttons.length; i++) {

            btnName = "Radio " + btnCtr;
            buttons[i] = new Button(btnName);

            hBox.getChildren().add(buttons[i]);
            btnCtr++;
        }

    }


}