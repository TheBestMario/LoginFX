package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Stage stage;
    protected static FXMLLoader fxmlLoader;
    protected Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;

        fxmlLoader = new FXMLLoader(Application.class.getResource("StartView.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);

        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);
        this.stage.show();
    }
    public static Stage getStage(){
        return stage;
    }
    public static void setFxmlLoader(FXMLLoader fxmlLoader){
        Application.fxmlLoader = fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
    }
}