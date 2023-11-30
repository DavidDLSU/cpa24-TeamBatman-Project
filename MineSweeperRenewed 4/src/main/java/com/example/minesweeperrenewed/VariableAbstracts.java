package com.example.minesweeperrenewed;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public abstract class VariableAbstracts {
    public List<String> organizationContacts;
    public List<String> contacts;
    public int currentIndex;
    public List<String> healthcareContacts;
    public List<String> quotes;
    @FXML
    protected Label prompt;
    @FXML
    protected TextField username;
    @FXML
    protected PasswordField password;
    @FXML
    protected Label contactsLabel;
    @FXML
    protected Label quoteLabel;
    @FXML
    protected TextArea moodEntryTextArea;
    @FXML
    protected ListView<String> moodEntriesListView;
    protected ObservableList<String> moodEntries;
}
