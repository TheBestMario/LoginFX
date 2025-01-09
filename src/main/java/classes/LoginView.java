package classes;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginView {

    @FXML
    public void onSubmitClicked() throws IOException {
        System.out.println("Submit Clicked");
        Application.getSceneController().switchToScene("StartView.fxml");
    }
}
