// src/main/java/classes/Application.java
package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static SceneController sceneController;

    @Override
    public void start(Stage stage) throws IOException {
        sceneController = new SceneController(stage);
        sceneController.switchToScene("StartView.fxml");
    }

    public static SceneController getSceneController() {
        return sceneController;
    }

    public static void main(String[] args) {
        launch();
    }
}