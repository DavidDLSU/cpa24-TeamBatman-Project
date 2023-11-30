module com.example.minesweeperrenewed {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minesweeperrenewed to javafx.fxml;
    exports com.example.minesweeperrenewed;
}