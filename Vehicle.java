/**
 * @author Mirna Sabljak
 */
public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    private String VIN;
    private String fuelType;

    public Vehicle(String make, String model, int year, String color, String VIN, String fuelType){
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.VIN = VIN;
        this.fuelType = fuelType;
    }

    public Vehicle() {};

    public String getMake() {

        return make;
    }

    public String getModel() {

        return model;
    }

    public int getYear(){

        return year;
    }

    public String getColor() {

        return color;
    }

    public String getVIN() {

        return VIN;
    }

    public String getFuelType() {

        return fuelType;
    }

}
