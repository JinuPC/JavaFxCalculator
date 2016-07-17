package org.litech.licalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage pStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 400, 500));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
