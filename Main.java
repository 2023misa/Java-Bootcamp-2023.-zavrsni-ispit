import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Ovo je glavni program - Sustav upravljanja vozilima u floti.
 * @author Mirna Sabljak
 */
public class Main {
    public static void main(String[] args) {

        boolean flag = true;
        String command1;
        int command;
        VehicleManagerImpl vehicleM = new VehicleManagerImpl();
        Logger log = Logger.getLogger(Main.class.getName());
        Scanner scanner = new Scanner(System.in);

        do {
        //ponavljaj isto dok god korisnik to želi
            System.out.println("Vehicle Fleet Management System");
            System.out.println("-------------------------------");
            System.out.println("1. Add a vehicle to the fleet");
            System.out.println("2. Search for vehicles by make or model");
            System.out.println("3. Print all vehicles in the fleet");
            System.out.println("4. Delete a vehicle from the fleet");
            System.out.println("5. Quit");
            System.out.print("Enter command: ");

            command1 = scanner.nextLine();

        //ako je korisnik unio slova izbaci iznimku
            try {
                command = Integer.parseInt(command1);

        //ako je unio broj, ali ni jedan od ponuđenih izbaci poruku
                if (command > 5 ||  command < 1) {
                    System.out.println("Invalid input. Please enter a valid integer between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer between 1 and 5.");
                continue;
            }

            switch (command) {
                case 1 :
        //ako korisnik pokušava unijeti vozilo s već postojećim VIN-om uhvati iznimku
                        try {
                            vehicleM.addAVehicle();
                         }catch (DuplicateVehicleException e) {
                            System.out.println("Error: " + e.getMessage());
                         }
                         break;
                case 2 : vehicleM.searchForVehicles();
                         break;
                case 3 : vehicleM.printAllVehicles();
                         break;
                case 4 :
        //ako korisnik pokušava obrisati vozilo koje ne postoji uhvati iznimku
                         try {
                                vehicleM.deleteAVehicle();
                         }catch (NoSuchVehicleException e) {
                                System.out.println("Error: " + e.getMessage());
                         }
                         break;
                case 5 : flag = false;
                         break;
            };

        }while(flag);
        scanner.close();
        log.info("The end!");
    }
}