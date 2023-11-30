package com.example.minesweeperrenewed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LogoutController {
    @FXML
    private void onLogout(ActionEvent e) throws IOException {
        MenuApplication loginApp = new MenuApplication();
        loginApp.changeScene("login-view.fxml");
    }
}
