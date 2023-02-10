package com.example.pausetasks;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private final Button[] RadioBtns = new Button[10];
    private final Button[] keyBoardBtns = new Button[25];
    public AnchorPane rootPane;
    public HBox hBox;
    public Button btnAddRadio;
    public Button btnRemoveKeyboard;
    public Button tstBtn;

    public int btnCtr;
    public String btnName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCtr = 0;
        hBox.setSpacing(10);

        Button removeBtn = new Button("Remove Radios");
        hBox.getChildren().add(removeBtn);
        removeBtn.setOnAction(e -> removeRadioButtons());

        Button makeKeyboard = new Button("Make keyboard");
        tstBtn = new Button("Test");
        hBox.getChildren().add(makeKeyboard);
        hBox.getChildren().add(tstBtn);
        makeKeyboard.setOnAction(e -> makeKeyboardButtons());
        tstBtn.setOnAction(e -> testChar());

        btnRemoveKeyboard= new Button("Remove Keyboard");
        btnRemoveKeyboard.setOnAction(e-> removeKeyboardButtons());
        btnRemoveKeyboard.setDisable(true);
        hBox.getChildren().add(btnRemoveKeyboard);

    }

    public void addRadioFunc() {
        btnCtr = 1;
        for (int i = 0; i < RadioBtns.length; i++) {

            btnName = "Radio " + btnCtr;
            RadioBtns[i] = new Button(btnName);
            hBox.getChildren().add(RadioBtns[i]);
            btnCtr++;
        }

    }

    public void removeRadioButtons() {

        for (Button button : RadioBtns) hBox.getChildren().remove(button);

    }

    public void makeKeyboardButtons() {
        int btnCtr = 0;

        for (int i = 65; i < 90; i++) {
            String ascLabel = Character.toString(i);
            keyBoardBtns[btnCtr] = new Button(ascLabel);
            int finalBtnCtr = btnCtr;
            keyBoardBtns[btnCtr].setOnAction(e -> keyBoardBtns[finalBtnCtr].setDisable(true));
            hBox.getChildren().add(keyBoardBtns[btnCtr]);
            btnCtr++;
        }

    }

    public void testChar() {

        for (int i = 65; i < 90; i++) {
            String tst = Character.toString(i);
            System.out.println("test char is " + tst);
        }


    }

    public void removeKeyboardButtons() {
        for (Button keyBoardBtn : keyBoardBtns) {
            hBox.getChildren().remove(keyBoardBtn);
        }
    }

}