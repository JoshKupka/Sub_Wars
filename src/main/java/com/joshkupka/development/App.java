package com.joshkupka.development;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Hello world!
 */
public class App extends Application {

    Database database = new Database();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("dashboard.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("dashboard.css").toExternalForm());

        stage.setTitle("Sub Wars");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Path path = Paths.get("UserData.json");
        if (Files.exists(path)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

            database.databaseInit();
            database.putData("First-Run", true);
        }

    }

    public static void main(String[] args){
        launch();
    }
}
