import java.lang.*;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        //pre-filled data
        VehicleCRUD crud = new VehicleCRUD();
        crud.create(1, 2012, "honda", "civic");
        crud.create(2, 2016, "bmw", "x1");
        crud.create( 3,2021, "tesla", "s");

        // main menu
        String WELCOME_MSG = "Welcome to my vehicle shop! What would you like to do?";
        String OPTION_MSG = "\n1. Get Vehicles\n" +
                "2. Get Vehicles by ID\n" +
                "3. Create vehicle\n" +
                "4. Update vehicles\n" +
                "5. Delete vehicle's ID\n" +
                "6. Get Vehicles by Make\n" +
                "7. Exit program\n";

        boolean EXIT_OPTION = false;
        Scanner input = new Scanner(System.in);
        System.out.println(WELCOME_MSG);
        while(!EXIT_OPTION){
            System.out.println(OPTION_MSG);
            int choose = input.nextInt();
            switch (choose){
                case 1:
                    // get vehicle
                    ArrayList<Vehicle> allVehicles = crud.getVehicles();
                    for(Vehicle vehicle: allVehicles){
                        System.out.println(vehicle.getMake() + " "
                                + vehicle.getModel() + " "
                                + vehicle.getYear()
                        );
                    }
                    break;

                case 2:
                    // get vehicle's by id
                    System.out.println("Please enter your ID");
                    int idInput = input.nextInt();
                    Vehicle current = crud.getVehiclesById(idInput);
                    // if valid, proceed outputting
                    if(current != null){
                        System.out.println(current.getMake() + " "
                                + current.getModel() + " "
                                + current.getYear());
                    }
                    break;
                case 3:
                    // create vehicle
                    System.out.println("Please enter all of the required data:\n");
                    System.out.println("1. ID");
                    idInput = input.nextInt();
                    System.out.println("2. Year (Must be between 1950-2050)");
                    int yearInput = input.nextInt();
                    System.out.println("3. Make");
                    String makeInput = input.next().toLowerCase();
                    System.out.println("4. Model");
                    String modelInput = input.next().toLowerCase();
                    // For the purpose of testing the crud, we still proceed when any of the prior input is invalid.
                    crud.create(idInput, yearInput, makeInput, modelInput);
                    break;
                case 4:
                    // update vehicle
                    System.out.println("Please enter your ID");
                    idInput = input.nextInt();
                    System.out.println("Please enter your new:");
                    System.out.println("1. ID");
                    int newIDInput = input.nextInt();
                    System.out.println("2. Year (Must be between 1950-2050)");
                    yearInput = input.nextInt();
                    System.out.println("3. Make");
                    makeInput = input.next().toLowerCase();
                    System.out.println("4. Model");
                    modelInput = input.next().toLowerCase();
                    crud.update(idInput, newIDInput, yearInput, makeInput, modelInput);
                    break;
                case 5:
                    // delete vehicle by id
                    System.out.println("Please enter your id");
                    idInput = input.nextInt();
                    crud.deleteById(idInput);
                    break;
                case 6:
                    System.out.println("Please enter make:");
                    makeInput = input.next().toLowerCase();
                    ArrayList<Vehicle> foundMatches = crud.getVehiclesByMake(makeInput);
                    if(!foundMatches.isEmpty()){
                        for(Vehicle vehicle: foundMatches){
                            System.out.println(vehicle.getMake() + " "
                                    + vehicle.getModel() + " "
                                    + vehicle.getYear()
                            );
                        }
                    }
                    break;
                case 7:
                    // exit program
                    EXIT_OPTION = true;
                    System.out.println("Bye!");
                    break;
                default:
                    // arbitrary unknown input
                    System.out.println("Please enter only the available option (1-6)");
            }
        }
    }
}
