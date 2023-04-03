/**
 * @author Mirna Sabljak
 */
public class Truck extends Vehicle{
    private double towingCapacity;

    public Truck(String make, String model, int year, String color, String VIN, String fuelType, double towingCapacity){
        super(make, model, year, color, VIN, fuelType);
        this.towingCapacity = towingCapacity;
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    //ovaj override mi služi za željeni ispis vozila u metodama printAllVehicles i searchForVehicles
    @Override
    public String toString(){
        return "Truck{make=" + "'"+getMake()+"'" + ", model=" +"'"+getModel()+"'"+ ", year=" + getYear() + ", color=" + "'"+getColor()+"'" + ", vin=" + "'"+getVIN()+"'" + ", fuelType=" + "'"+getFuelType()+"'" +  ", maxPayload=" + +getTowingCapacity()+"}";
    }
}
