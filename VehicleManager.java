/**
 * @author Mirna Sabljak
 */
public interface VehicleManager {
    void addAVehicle() throws DuplicateVehicleException;
    void searchForVehicles();
    void printAllVehicles();
    void deleteAVehicle() throws NoSuchVehicleException;
}
