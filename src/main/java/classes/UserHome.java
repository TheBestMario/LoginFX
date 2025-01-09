package classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserHome {

    @FXML
    public Label welcomeMessage;

    public void setWelcomeMessage(){
        welcomeMessage.setText("Welcome, "+Application.getCurrentLoggedIn().getUsername());
    }
}
