package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    public Button helloButton;

    @FXML
    protected void onLoginButtonClick() {

    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent actionEvent) {
        helloButton.setStyle("-fx-background-color: #ffffff;");
    }

}
