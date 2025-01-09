// src/main/java/classes/StartView.java
package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartView {
    @FXML
    public Button helloButton;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        Application.getSceneController().switchToScene("LoginView.fxml");
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent actionEvent) {
        helloButton.setStyle("-fx-background-color: #ffffff;");
    }
}