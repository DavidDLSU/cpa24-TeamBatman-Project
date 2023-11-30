package com.example.minesweeperrenewed;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginController extends VariableAbstracts {

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        MenuApplication loginApp = new MenuApplication();
        loginApp.changeScene("intro-view.fxml");
    }

}
