/**class CarDatabase
 * @author Matteo Falkenberg
 * @version 1.4, 14.01.2021
 */

package model;

import java.util.HashMap;
import java.util.LinkedList;

public class CarDatabase {

    protected HashMap<String, Vehicle> db = new HashMap();


    public CarDatabase(){

        MagicGenerator mGen = new MagicGenerator();

        for(int i = 0; i < 1000; i++){
            Vehicle car = new Vehicle();
            car.setLicensePlate(mGen.getRandomLicencePlate());
            car.setManufacturer(mGen.getRandomManufacturer());
            car.setModel(mGen.getRandomModel(car.getManufacturer()));
            car.setColor(mGen.getRandomColor());
            car.setOwner(mGen.getRandomName());
            db.put(car.getLicensePlate(), car);

            System.out.println("Created vehicle with license plate " + car.getLicensePlate());
        }

    }


    public LinkedList<Vehicle> search(String licensePlate, boolean exact){

        LinkedList<Vehicle> vehicles = new LinkedList();

        if(exact){
            vehicles.add(db.get(licensePlate));
            return vehicles;
        }

        else{
            for(Vehicle v : db.values()){

                if(v.getLicensePlate().contains(licensePlate.toUpperCase())){
                    vehicles.add(v);
                }
            }
            return vehicles;
        }
    }

}
