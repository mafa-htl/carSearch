/**class Controller
 * @author Matteo Falkenberg
 * @version 1.5, 14.01.2021
 */

package sample;

import javafx.collections.FXCollections;
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

        if(list != null) {      //check if list is empty
            LinkedList<String> licensePlateList = new LinkedList<String>();

            for (Vehicle v : list) {      //add license plates of all vehicles in list to licensePlateList
                licensePlateList.add(v.getLicensePlate());
            }

            displayField.setItems(FXCollections.observableArrayList(licensePlateList));     //convert licensePlateList to observableArrayList and displays it in display Field
        }
        else
            displayField.setItems(null);
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
