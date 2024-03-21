package audiosystem.config;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * ConfigManagerUI
 * A JavaFX application for managing system configurations.
 */
public class ConfigManagerUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Open Configuration");

        btn.setOnAction(event -> {
            // Open configuration dialog or window
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Audio Processing System Configuration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void launchUI(String[] args) {
        launch(args);
    }
}
