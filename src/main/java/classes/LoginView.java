package classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Map;

public class LoginView {
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    public Label informationLabel;
    @FXML
    public void onSubmitClicked() throws IOException {
        System.out.println("Submit Clicked");
        informationLabel.setText(null);
        String username = usernameField.getText();
        String password = passwordField.getText();



        for (Map.Entry<String, Boolean> entry : Profile.ProfileCheck(username,password).entrySet()){
            if (entry.getKey().equals("userExists") && entry.getValue()){

            }
            switch (entry.getKey()) {

                case "userExists":
                    if (entry.getValue()){
                        System.out.println("username exists");
                    } else{
                        System.out.println("account doesn't exist, please make a new account");
                        informationLabel.setStyle("-fx-text-fill: red");
                        informationLabel.setText("Account doesn't exist, please make a new account");
                        return;
                    }
                case "pwdMatches":
                    if (entry.getValue()){
                        System.out.println(entry.getValue());
                        System.out.println("password matches account, logging in...");
                        informationLabel.setStyle("-fx-text-fill: green");
                        informationLabel.setText("Logging in...");
                    } else{
                        System.out.println("incorrect password, please try again.");
                        informationLabel.setStyle("-fx-text-fill: red");
                        informationLabel.setText("incorrect password, please try again.");

                    }
                    return;
            }

        }
//        if (Profile.ProfileCheck(username,password)) {
//            Application.getApplication().switchToScene("StartView.fxml");
//        };
    }

}
