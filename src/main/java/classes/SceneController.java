package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController{
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    public SceneController(Stage stage){
        this.stage = stage;
    }
    public void switchToScene(String fileName) throws IOException {
        root = new FXMLLoader(getClass().getResource(fileName));
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
}
