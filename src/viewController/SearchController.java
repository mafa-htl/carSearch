/**class SearchController
 * @author Matteo Falkenberg
 * @version 1.6, 14.01.2021
 */

package viewController;

import detailVC.DetailController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import database.CarDatabase;
import javafx.stage.Stage;
import model.Vehicle;

import java.util.LinkedList;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private ListView displayField;

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

    @FXML
    private void openMoreInfo(){
        Vehicle car = cars.search(displayField.getSelectionModel().getSelectedItem().toString(), true).getFirst();

        try{
            Stage detailStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/detailVC/detailView.fxml"));
            Parent secondaryStage = loader.load();
            detailStage.setTitle("Vehicle Information");
            detailStage.setScene(new Scene(secondaryStage, 150, 200));
            detailStage.show();

            DetailController detailController = loader.getController();     //Get Access to DetailController
            detailController.displayInfoInFields(car);      //initialize displayInfoInFields of detailController

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
