/**class CarDatabase
 * @author Matteo Falkenberg
 * @version 1.5, 14.01.2021
 */

package model;

import java.util.HashMap;
import java.util.LinkedList;

public class CarDatabase {

    protected HashMap<String, Vehicle> db = new HashMap();


    public CarDatabase(){

        MagicGenerator mGen = new MagicGenerator();

        for(int i = 0; i < 1000; i++){      //randomly create 1000 Vehicles
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

        long startTime = System.currentTimeMillis();     //assigns current time to variable
        LinkedList<Vehicle> vehicles = new LinkedList();

        if(exact){
            vehicles.add(db.get(licensePlate));
            System.out.println("Search took: " + (System.currentTimeMillis() - startTime) + "ms (exact)");     //prints out time the exact search took

            if(vehicles.getFirst() != null)     //check if a vehicle has been found
                return vehicles;
            else
                return null;
        }

        else{
            for(Vehicle v : db.values()){

                if(v.getLicensePlate().contains(licensePlate.toUpperCase())){   //checks for licensePlates that contain search String
                    vehicles.add(v);
                }
            }
            System.out.println("Search took: " + (System.currentTimeMillis() - startTime) + "ms (pattern search)");    //prints out time the pattern search took
            return vehicles;
        }
    }

}
