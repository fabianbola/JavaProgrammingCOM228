package com.example.danielbolanos_comp228lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 440);
        stage.setTitle("Game form!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();

    }

    public static Connection initializeDB() throws Exception {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@199.212.26.208:1521:SQLD",
                    " COMP228_F24_sy_124",
                    "password"
            );
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return connection;
    };
}
