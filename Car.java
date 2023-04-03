/**
 * @author Mirna Sabljak
 */
public class Car extends Vehicle{
    private int numberOfDoors;
    private String bodyStyle;

    public Car(String make, String model, int year, String color, String VIN, String fuelType, int numberOfDoors, String bodyStyle){
        super(make, model, year, color, VIN, fuelType);
        this.numberOfDoors = numberOfDoors;
        this.bodyStyle = bodyStyle;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }
//ovaj override mi služi za željeni ispis vozila u metodama printAllVehicles i searchForVehicles
    @Override
    public String toString(){
        return "Car{make=" + "'"+getMake()+"'" + ", model=" +"'"+getModel()+"'"+ ", year=" + getYear() + ", color=" + "'"+getColor()+"'" + ", vin=" + "'"+getVIN()+"'" + ", fuelType=" + "'"+getFuelType()+"'" + ", numDoors=" + getNumberOfDoors() + ", bodyStyle=" + "'"+getBodyStyle()+"'}";
    }
}
