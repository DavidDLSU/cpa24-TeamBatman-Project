package com.example.minesweeperrenewed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private void easyMode(ActionEvent event) throws Exception {
        DifficultyEasy easy = new DifficultyEasy();
        Stage stage = new Stage();
        easy.start(stage);
    }

    @FXML
    private void mediumMode(ActionEvent event) throws Exception {
        DifficultyMed med = new DifficultyMed();
        Stage stage = new Stage();
        med.start(stage);
    }

    @FXML
    private void hardMode(ActionEvent event) throws Exception {
        DifficultyHard hard = new DifficultyHard();
        Stage stage = new Stage();
        hard.start(stage);
    }

    @FXML
    private void credits(ActionEvent event) throws IOException {
        MenuApplication loginApp = new MenuApplication();
        loginApp.changeScene("credits.fxml");
    }
}
