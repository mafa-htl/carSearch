/**class Controller
 * @author Matteo Falkenberg
 * @version 1.4, 14.01.2021
 */

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.CarDatabase;
import model.Vehicle;

import java.util.LinkedList;

public class Controller {

    @FXML
    TextField searchField;

    @FXML
    ListView displayField;

    private CarDatabase cars = new CarDatabase();

    private void displayResults(LinkedList<Vehicle> list){

        for(Vehicle v : list){

        }

        displayField.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void searchExact(){

    displayResults(cars.search(searchField.getText(), true));

    }

    @FXML
    private void searchFor(){

        displayResults(cars.search(searchField.getText(), false));

    }

}
