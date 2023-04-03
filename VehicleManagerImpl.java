import java.util.*;
/**
 * Ovo je klasa koja simulira sustav upravljanja vozilima u floti.
 * Moguće je dodati i obrisati pojedino vozilo, pretražiti postoji li vozilo u floti te ga izbrisati iz flote ako postoji.
 * @author Mirna Sabljak
 */
public class VehicleManagerImpl implements VehicleManager{

        public List<Vehicle> vozila = new ArrayList<>();
        public VehicleManagerImpl(){
        }
        Scanner scanner = new Scanner(System.in);
        @Override
        public void addAVehicle () throws DuplicateVehicleException {
            System.out.println("");
            System.out.println("What type of vehicle you would like to add?");
            System.out.print("Enter 'car' or 'truck: ");
            String type = scanner.nextLine();
            int year;

            if (type.equals("car") || type.equals("truck")) {
                System.out.print("Enter make: ");
                String make = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();

            //do ovdje ce biti uvijek ok
                System.out.print("Enter year: ");
                String input = scanner.nextLine();

            //ako korisnik unese slova za year uhvati iznimku
                try {
                        year = Integer.parseInt(input);
                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter VIN: ");
                        String vin = scanner.nextLine();

            //ako je korisnik već unio vozilo s tim VIN-om baci iznimku
                        for(Vehicle vozilo : vozila) {
                            String vin1 = String.valueOf(vozilo.getVIN());
                            if(vin.equals(vin1)){
                                throw new DuplicateVehicleException("There is already a vehicle with that VIN in the fleet!");
                            }
                        }
                        System.out.print("Enter fuel type: ");
                        String fuelType = scanner.nextLine();

            //ovdje se kod počinje razlikovati ovisno dodajem li auto ili kamion
                        if (type.equals("car")) {
                            System.out.print("Enter number of doors: ");
                            String input2 = scanner.nextLine();

            //ako je korisnik unio slova za number of doors uhvati iznimku
                            try {
                                int doors = Integer.parseInt(input2);
                                System.out.print("Enter body style: ");
                                String bodyStyle = scanner.nextLine();
                                Car auto = new Car(make, model, year, color, vin, fuelType, doors, bodyStyle);
                                vozila.add(auto);
                                System.out.println("Vehicle added successfully.");
                            }catch (NumberFormatException e) {
                                    System.out.println("Error: Invalid input, number of doors should be a number.");
                            }
                        }
            //dodajemo kamion
                        else {
            //ako je korisnik unio slova za towing capacity uhvati iznimku
                            System.out.print("Enter towing capacity: ");
                            try {
                                String input3 = scanner.nextLine();
                                double towingCap = Double.parseDouble(input3);
                                Truck kamion = new Truck(make, model, year, color, vin, fuelType, towingCap);
                                vozila.add(kamion);
                                System.out.println("Vehicle added successfully.");
                                }
                            catch (NumberFormatException e) {
                                System.out.println("Error: Invalid input, towing capacity should be a number.");
                            }
                        }
                } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input, year should be a number.");
                        }
            //ako je korisnik unio nešto drugo osim car ili truck
            }else {
                System.out.println("Wrong type of vehicle, can't add it.");
            }
            System.out.println("");

        }
        @Override
        public void searchForVehicles(){
            System.out.println("");
            System.out.println("How would you like to search for vehicles?");
            System.out.println("1. Search by make");
            System.out.println("2. Search by model");

            //dok god korisnik ne unese dobar broj vraća ga na početak
            do {
                System.out.print("Enter command: ");
                String type = scanner.nextLine();
                int number;

            //ako korisnik unese slova izbaci iznimku
                try {
                    number = Integer.parseInt(type);
                    int flag = 0;
            //ako je unio 1 pretražujemo po make
                    if (number == 1) {
                        System.out.print("Enter make: ");
                        String make = scanner.nextLine();
                        System.out.println("Search results: ");

                        for(Vehicle vozilo : vozila){
                            String make1 = String.valueOf(vozilo.getMake());
                            if(make.equals(make1)){
                                System.out.println(vozilo);
                                flag = 1;
                            }
                        }
                        if(flag == 0) {
                            System.out.println("There is no such vehicle in the fleet.");
                        }
            //ako je unio 2 po model
                    } else if (number == 2) {
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.println("Search results: ");

                        for(Vehicle vozilo : vozila){
                            String model1 = String.valueOf(vozilo.getMake());
                            if(model.equals(model1)){
                                System.out.println(vozilo);
                                flag = 1;
                            }
                        }
                        if(flag == 0) {
                            System.out.println("There is no such vehicle in the fleet.");
                        }

                    } else {
            //ako je unio broj koji nije ni 1 ni 2
                        System.out.println("Invalid command. Please enter a number between 1 and 2");
                        continue;
                    }
            //break jer je sve dobro unio pa možemo van
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command. Please enter a number between 1 and 2");
                    continue;
                }
            }while(true);
            System.out.println("");
        }

        @Override
        public void printAllVehicles(){
            System.out.println("");
            if(vozila.isEmpty()) {
                System.out.println("The fleet is empty.");
            } else {
                System.out.println("All vehicles in the fleet: ");
                for (Vehicle vozilo : vozila) {
                    System.out.println(vozilo);
                }
            }
            System.out.println("");
        }

        @Override
        public void deleteAVehicle() throws NoSuchVehicleException{
            System.out.println("");
            System.out.print("Enter VIN of vehicle to delete: ");
            String vin = scanner.nextLine();
            boolean flag = false;
            Vehicle vozilo = new Vehicle();

            for(int i = 0 ; i < vozila.size();  i++){
                vozilo = vozila.get(i);
                String vin2 = String.valueOf(vozilo.getVIN());
                if (vin.equals(vin2)){
                    vozila.remove(vozilo);
                    flag = true;
                }
            }
            if (!flag){
                throw new NoSuchVehicleException("There is no such vehicle in the fleet!");
            }
            System.out.println("Vehicle with VIN "+ vin +" deleted successfully.");
            System.out.println("");
        }

}
