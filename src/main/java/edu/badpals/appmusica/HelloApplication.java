package edu.badpals.appmusica;

import edu.badpals.appmusica.entities.Test;
import edu.badpals.appmusica.service.DBConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        try {
            DBConnector conn = new DBConnector();
            Test test = new Test("MyTest");
            conn.insertTest(test);
            Test test2 = conn.getTest(1);
            System.out.println(test2.getTest_string());
        } catch (HibernateException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }
}