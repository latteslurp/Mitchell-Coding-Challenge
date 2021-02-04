import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VehicleCRUD{
    // map to store all vehicles
    private static Map<Integer, Vehicle> garage = new HashMap<>();

    //=================================================================
    //Helper Methods
    public boolean isValidEntity(int id, int year, String make, String model){
        if(isUniqueIDHelper(id) && isValidYearHelper(year) && isValidMakeHelper(make) && isValidModelHelper(model)){
            return true;
        }
        // output invalid message for the following invalid input(s), then return false
        // used-id
        if(!isUniqueIDHelper(id)){
            System.out.println("ID has been taken.");
        }
        // year invalid
        if(!isValidYearHelper(year)){
            System.out.println("Invalid year input.");
        }
        // make invalid
        if(!isValidMakeHelper(make)){
            System.out.println("Invalid make input.");
        }
        // model invalid
        if(!isValidModelHelper(model)){
            System.out.println("Invalid model input.");
        }
        return false;
    }
    public boolean isUniqueIDHelper(int id){
        return !garage.containsKey(id);
    }

    public boolean isValidYearHelper(int year){
        return year >= 1950 && year <= 2050;
    }

    public boolean isValidMakeHelper(String make){
        return make != null && !make.trim().isEmpty();
    }

    public boolean isValidModelHelper(String model){
        return model != null && !model.trim().isEmpty();
    }

    public void invalidID(){
        System.out.println("Invalid ID");
    }


    //==================================================================
    //CRUD Implementation
    //each vehicle should have a unique id
    public Vehicle create(int id, int year, String make, String model){
        if(isValidEntity(id, year, make, model)){
            // success creation
            Vehicle newVehicle = new Vehicle(id, year, make.toLowerCase(), model.toLowerCase());
            // put in garage
            garage.put(id, newVehicle);
            System.out.println("-- Create success!");
            return newVehicle;
        }
        System.out.println("Unsuccessful creation.");
        return null;
    }

    // update vehicle info -> except id, it should always maintain as the creation id!
    public boolean update(int oldID, int newID, int year, String make, String model){
        if(garage.containsKey(oldID)){
            Vehicle toUpdate = garage.get(oldID);
            if(isValidEntity(newID, year, make, model)){
                toUpdate.setId(newID);
                toUpdate.setYear(year);
                toUpdate.setMake(make);
                toUpdate.setModel(model);
                toUpdate.setModel(model.toLowerCase());
                //Successful update -> update garage
                garage.remove(oldID);
                garage.put(newID, toUpdate);
                System.out.println("-- Update success!");
                return true;
            }
            System.out.println("Unsuccessful update.");
        }
        else{
            invalidID();
        }
        return false;
    }

    public ArrayList<Vehicle> getVehicles(){
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        for(int key: garage.keySet()){
            allVehicles.add(garage.get(key));
        }
        return allVehicles;
    }

    public Vehicle getVehiclesById(int id){
        if(garage.containsKey(id)){
            return garage.get(id);
        }
        // if not a valid id, return null
        invalidID();
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMake(String make){
        // store all vehicles by the make
        ArrayList<Vehicle> matchByMake = new ArrayList<>();
        for(int key: garage.keySet()){
            Vehicle current = garage.get(key);
            if(current.getMake().equals(make.toLowerCase())){
                matchByMake.add(current);
            }
        }
        return matchByMake;
    }

    public boolean deleteById(int id){
        // if to-delete car exist, then deletion is successful
        if(garage.containsKey(id)){
            garage.remove(id);
            System.out.println("-- Delete success!");
            return true;
        }
        // otherwise, it is an unsuccessful deletion
        invalidID();
        System.out.println("Unsuccessful deletion.");
        return false;
    }

    public void destructor(){
        garage.clear();
    }
}
