// src/main/java/classes/Application.java
package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    //private static SceneController sceneController;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    private static Application app;

    @Override
    public void start(Stage stage) throws IOException {
        app = this;
        this.stage = stage;
        switchToScene("StartView.fxml");

    }

    public static Application getApplication(){
        return app;
    }

    public void switchToScene(String fileName) throws IOException {
        root = new FXMLLoader(getClass().getResource(fileName));
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}