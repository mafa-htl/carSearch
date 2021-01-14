/**class DetailController
 * @author Matteo Falkenberg
 * @version 1.6, 14.01.2021
 */

package detailVC;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Vehicle;

public class DetailController {

    @FXML
    private TextField plateField;

    @FXML
    private TextArea detailField;

    public void displayInfoInFields(Vehicle car){
        this.plateField.setText(car.getLicensePlate());
        this.detailField.setText(car.toString());
    }

}
