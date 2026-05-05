package com.example.mediator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class ChatClientController {

    @FXML private TextArea chatArea;
    @FXML private TextField messageField;
    @FXML private ComboBox<String> recipientBox;
    @FXML private Label titleLabel;

    private ChatMediator mediator;
    private String username;

    public void init(String username, ChatMediator mediator, List<String> users) {
        this.username = username;
        this.mediator = mediator;

        titleLabel.setText("User: " + username);

        recipientBox.getItems().setAll(
                users.stream()
                        .filter(u -> !u.equals(username))
                        .toList()
        );

        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    @FXML
    public void sendMessage() {
        String msg = messageField.getText();
        String to = recipientBox.getValue();

        if (msg == null || msg.isBlank() || to == null) return;

        mediator.sendMessage(msg, username, to);
        messageField.clear();
    }

    public void receiveMessage(String message) {
        javafx.application.Platform.runLater(() ->
                chatArea.appendText(message + "\n")
        );
    }
}