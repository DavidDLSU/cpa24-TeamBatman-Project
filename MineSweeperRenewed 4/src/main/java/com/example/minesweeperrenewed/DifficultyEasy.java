package com.example.minesweeperrenewed;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DifficultyEasy extends Application {

    private Text timerText = new Text("Time Elapsed: 0 seconds");
    private Timeline timeline;
    private int elapsedTimeInSeconds = 0;
    private static final int TILE_SIZE = 40;
    private static final int W = 320;
    private static final int H = 360;
    private int bombThreshold = 2;
    private static final int X_TILES = 8;
    private static final int Y_TILES = 8;

    private Tile[][] grid = new Tile[X_TILES][Y_TILES];
    private Scene scene;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(W, H);

        for (int y = 0; y < Y_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2);

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < Y_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb)
                    continue;

                long bombs = getNeighbors(tile).stream().filter(t -> t != null && t.hasBomb).count();
                // Flag the tile if it has a certain number of neighboring bombs
                if (bombs >= bombThreshold) {
                    tile.toggleFlag(); // Flag the tile if needed
                }
                if (bombs > 0)
                    tile.text.setText(String.valueOf(bombs));
            }
        }

        return root;
    }

    private List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        // ttt
        // tXt
        // ttt

        int[] points = new int[] {
                -1, -1,
                -1, 0,
                -1, 1,
                0, -1,
                0, 1,
                1, -1,
                1, 0,
                1, 1
        };

        for (int i = 0; i < points.length; i++) {
            int dx = points[i];
            int dy = points[++i];

            int newX = tile.x + dx;
            int newY = tile.y + dy;

            if (newX >= 0 && newX < X_TILES
                    && newY >= 0 && newY < Y_TILES) {
                neighbors.add(grid[newX][newY]);
            }
        }

        return neighbors;
    }

    private class Tile extends StackPane {
        private int x, y;
        private boolean hasBomb;
        private boolean isOpen = false;
        private boolean isFlagged = false;
        private Rectangle border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
        private Text text = new Text();

        public Tile(int x, int y, boolean hasBomb) {
            this.x = x;
            this.y = y;
            this.hasBomb = hasBomb;

            border.setStroke(Color.GRAY);
            border.setFill(Color.LIGHTGRAY);

            text.setFont(Font.font(18));
            text.setText(hasBomb ? "X" : "");
            text.setVisible(false);

            getChildren().addAll(border, text);

            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);

            setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.PRIMARY) {
                    open();
                } else if (e.getButton() == MouseButton.SECONDARY) {
                    toggleFlag();
                    text.setVisible(true);
                }
            });

            // Set the text color based on the number
            if (!hasBomb) {
                int bombs = (int) getNeighbors(this).stream().filter(t -> t != null && t.hasBomb).count();
                setColorBasedOnNumber(bombs);
            }
        }

        public void toggleFlag() {
            if (!isOpen) {
                isFlagged = !isFlagged;
                text.setText(isFlagged ? "F" : ""); // Display "F" for flagged tiles
            }
        }

        public void open() {
            if (isOpen)
                return;

            if (hasBomb) {
                System.out.println("Game Over");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("YOU LOST");
                alert.setHeaderText("GAME OVER");
                String s = "TRY AGAIN?";
                alert.setContentText(s);
                alert.show();
                scene.setRoot(createContent());
                return;
            }

            isOpen = true;
            text.setVisible(true);
            border.setFill(null);

            if (text.getText().isEmpty()) {
                getNeighbors(this).forEach(Tile::open);
            }
        }

        private void setColorBasedOnNumber(int number) {
            switch (number) {

                case 1:
                    text.setFill(Color.BLUE);
                    break;
                case 2:
                    text.setFill(Color.RED);
                    break;
                case 3:
                    text.setFill(Color.GREEN);
                    break;

                default:
                    text.setFill(Color.BLACK);
                    break;
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(createContent());

        Pane root = (Pane) scene.getRoot();
        root.getChildren().add(timerText);
        timerText.setTranslateY(340);
        // Create a Timeline to update the timerText every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::updateTimer));
        timeline.setCycleCount(Timeline.INDEFINITE);

        stage.setScene(scene);
        stage.setTitle("Easy");
        stage.show();

        // Start the timer when the stage is shown
        timeline.play();
    }

    private void updateTimer(ActionEvent event) {
        elapsedTimeInSeconds++;
        timerText.setText("Time Elapsed: " + elapsedTimeInSeconds + " seconds");
    }


    public static void main(String[] args) {
        launch(args);
    }


}
