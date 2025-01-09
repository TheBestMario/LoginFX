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

    private static Profile currentLogin;

    @Override
    public void start(Stage stage) throws IOException {
        app = this;
        this.stage = stage;
        switchToScene("StartView.fxml");

    }

    public static Application getApplication(){
        return app;
    }

    public Stage getStage(){
        return stage;
    }

    public Object switchToScene(String fileName) throws IOException {
        root = new FXMLLoader(getClass().getResource(fileName));
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
        return root.getController();
    }
    public static void main(String[] args) {

        Profile.getProfileArray()[0] = new Profile("Luigi", "fakeman123");
        Profile.getProfileArray()[1] = new Admin("MarioG", "password");

        launch();
    }
    public static void setCurrentLoggedIn(Profile profile){
        currentLogin = profile;
    }
    public static Profile getCurrentLoggedIn(){
        return currentLogin;
    }
}