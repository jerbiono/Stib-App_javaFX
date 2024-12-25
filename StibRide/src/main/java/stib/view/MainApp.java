/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.view;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nadou
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("StibRide");
        URL viewFxPath = getClass().getResource("/fxml/search.fxml");
        FXMLLoader fileLoader = new FXMLLoader(viewFxPath);
        Parent parent = fileLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
