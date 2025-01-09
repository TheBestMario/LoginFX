package classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.io.IOException;

public class LoginView extends Application {
    @FXML
    private TextField username;
    private PasswordField password;
    public LoginView() throws IOException {
        fxmlLoader = new FXMLLoader(Application.class.getResource("LoginView.fxml"));
        System.out.println(fxmlLoader.getLocation());
        fxmlLoader.setController(this);
        scene = new Scene(fxmlLoader.load(), 600, 400);

        getStage().setScene(scene);
        getStage().show();
    }
    @FXML
    public void onSubmitClick() {
        System.out.println("submit clicked");

    }
}

