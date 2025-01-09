package classes;

import javafx.scene.control.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationViewController {

    public CheckBox policyCheckBox;
    public Button submitButton;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public Label informationLabel;

    public void onRegisterButtonClick() {

        informationLabel.setText("");
        informationLabel.setStyle("-fx-text-fill: red");
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmedPassword = confirmPasswordField.getText();

        boolean passwordMatches = false;
        boolean userChecked = false;
        //Map<String, Boolean> map = new HashMap<>();
        boolean checkBoxState = policyCheckBox.isSelected();


        if (username.isBlank()){
            System.out.println("You must fill in the username field.");
            informationLabel.setText("You must fill in the username field.");
        } else if (username.length() > 20) {
            System.out.println("username is too long, it must be less than 20 characters.");
            informationLabel.setText("Username is too long");
        } else if (Profile.checkUserNameExists(username)) {
            System.out.println("username already exists");
            informationLabel.setText("Username already exists.");
        } else{
            userChecked = true;
        }

        if (password.isBlank()){
            System.out.println("please fill in the password field");
            informationLabel.setText("please fill in the password field");
        } else if (password.length() < 5) {
            System.out.println("password is too short, must be more than 5 characters");
            informationLabel.setText("password is too short, must be more than 5 characters");
        } else if (password.equals(confirmedPassword)){
            passwordMatches = true;
        } else{
            System.out.println("Passwords must match");
            informationLabel.setText("Passwords must match");
        }

        if (!checkBoxState){
            System.out.println("You must agree to our policies");
            informationLabel.setText("You must agree to our policies");
        }



        if (userChecked && passwordMatches){
            informationLabel.setStyle("-fx-text-fill: green");
            informationLabel.setText("Creating account...");

            try {

                Application.getApplication().switchToScene("StartView.fxml");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //simulating big database wait or something
        }

//        for (Map.Entry<String, Boolean> entry : map.entrySet()){
//            switch (entry.getKey()) {
//                case "1.1":
//                    if (entry.getValue()) {
//                        System.out.println("please fill in the username");
//                    }
//                    break;
//                case "1.2":
//                    if (entry.getValue()) {
//                        System.out.println("username too long");
//                    }
//                    break;
//                case "2.1":
//                    if (entry.getValue()) {
//                        System.out.println("The password is empty, please fill it");
//                    }
//                    break;
//                case "2.2":
//                    if (entry.getValue()) {
//                        System.out.println("Password is too long");
//
//                    }
//                    break;
//            }
//        }
    }
}
