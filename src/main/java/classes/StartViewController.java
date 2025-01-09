package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartViewController {
    @FXML
    public Button helloButton;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        LoginView loginView = new LoginView();
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent actionEvent) {
        helloButton.setStyle("-fx-background-color: #ffffff;");
    }
}
