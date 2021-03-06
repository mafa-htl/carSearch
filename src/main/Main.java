/**class Main
 * @author Matteo Falkenberg
 * @version 1.6, 14.01.2021
 */

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/viewController/searchView.fxml"));
        primaryStage.setTitle("Vehicle Search");
        primaryStage.setScene(new Scene(root, 350, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
