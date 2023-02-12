package com.example.pausetasks;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private final Button[] RadioBtns = new Button[10];
    private final Button[] keyBoardBtns = new Button[26];
    public AnchorPane rootPane;
    public HBox hBox;
    public Button btnAddRadio;
    public Button btnRemoveKeyboard;
    public Button tstBtn;
    public Button btnMakeKeyboard;
    public Button btnRemoveRadios;
    public int btnCtr;
    public String btnName;
    public HBox btnHbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCtr = 0;
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10.0));
        btnHbox.setSpacing(10);

        btnRemoveRadios = new Button("Remove Radios");
        btnHbox.getChildren().add(btnRemoveRadios);
        btnRemoveRadios.setOnAction(e -> removeRadioButtons());

        btnMakeKeyboard = new Button("Make keyboard");
        tstBtn = new Button("Spare");

        btnMakeKeyboard.setOnAction(e -> makeKeyboardButtons());
        tstBtn.setOnAction(e -> testChar());

        btnRemoveKeyboard = new Button("Remove Keyboard");
        btnRemoveKeyboard.setOnAction(e -> removeKeyboardButtons());
        btnRemoveKeyboard.setDisable(true);
        btnRemoveRadios.setDisable(true);

        btnHbox.getChildren().add(btnMakeKeyboard);
        btnHbox.getChildren().add(btnRemoveKeyboard);
        btnHbox.getChildren().add(tstBtn);

    }

    public void addRadioFunc() {
        btnCtr = 1;
        for (int i = 0; i < RadioBtns.length; i++) {

            btnName = "Radio " + btnCtr;
            RadioBtns[i] = new Button(btnName);
            hBox.getChildren().add(RadioBtns[i]);
            btnCtr++;
        }
        btnRemoveRadios.setDisable(false);
        btnAddRadio.setDisable(true);
        removeKeyboardButtons();
    }

    public void removeRadioButtons() {

        for (Button button : RadioBtns) hBox.getChildren().remove(button);

        btnRemoveRadios.setDisable(true);
        btnAddRadio.setDisable(false);

    }

    public void makeKeyboardButtons() {
        int btnCtr = 0;

        removeRadioButtons();
        for (int i = 65; i <= 90; i++) {
            String ascLabel = Character.toString(i);
            keyBoardBtns[btnCtr] = new Button(ascLabel);

            int finalBtnCtr = btnCtr;
            keyBoardBtns[btnCtr].setOnAction(e -> keyBoardBtns[finalBtnCtr].setDisable(true));
            hBox.getChildren().add(keyBoardBtns[btnCtr]);
            btnCtr++;
            System.out.println(btnCtr + "btcr");
        }
        btnRemoveKeyboard.setDisable(false);
        btnMakeKeyboard.setDisable(true);

    }

    public void testChar() {

        for (int i = 65; i <= 90; i++) {
            String tst = Character.toString(i);
            System.out.println("test char is " + tst+" Char is "+i);
        }
    }

    public void removeKeyboardButtons() {
        for (Button keyBoardBtn : keyBoardBtns) {
            hBox.getChildren().remove(keyBoardBtn);
        }
        btnRemoveKeyboard.setDisable(true);
        btnMakeKeyboard.setDisable(false);
    }

}