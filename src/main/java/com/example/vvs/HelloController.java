package com.example.vvs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField port;


    @FXML
    protected void onStartButtonClick() throws IOException {
        UI.verifCommand("START");
    }

    @FXML
    protected void onPauseButtonClick() throws IOException {
        UI.verifCommand("PAUSE");
    }

    @FXML
    protected void onStopButtonClick() throws IOException {
        UI.verifCommand("STOP");
    }

    @FXML
    protected void onOkButtonClick() {
        int chosen_port = Integer.parseInt(port.getText());
        System.out.println("Chosen port is " + chosen_port);
        UI.init(chosen_port);
    }
}