// src/main/java/classes/StartView.java
package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartView {
    @FXML
    public Button loginButton;
    public Button registerButton;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        Application.getApplication().switchToScene("LoginView.fxml");
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent actionEvent) throws IOException {
        Application.getApplication().switchToScene("RegistrationView.fxml");
    }
}