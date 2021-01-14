/**class Vehicle
 * @author Matteo Falkenberg
 * @version 1.4, 14.01.2021
 */

package model;

public class Vehicle {

    private String color;
    private String owner;
    private String manufacturer;
    private String model;
    private String licensePlate;

    public Vehicle(){

    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Manufacturer: " + this.getManufacturer() + "\n");
        sb.append("Model: " + this.getModel() + "\n");
        sb.append("Color: " + this.getColor() + "\n");
        sb.append("License Plate: " + this.getLicensePlate() + "\n");
        sb.append("Owner: " + this.getOwner() + "\n\n");

        return sb.toString();
    }

}
