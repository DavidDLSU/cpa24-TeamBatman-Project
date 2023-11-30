package com.example.minesweeperrenewed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Credits {
    @FXML
    private void goBack(ActionEvent e) throws IOException {
        MenuApplication loginApp = new MenuApplication();
        loginApp.changeScene("intro-view.fxml");
    }
}
