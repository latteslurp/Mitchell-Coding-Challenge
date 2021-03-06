import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class VehicleCRUDTest {

    VehicleCRUD crud = new VehicleCRUD();
    private Vehicle testVehicle;

    @Before
    public void setup(){
        testVehicle = crud.create(0, 1968, "BMW", "Cooper");
	System.out.println("========(Method Test)========");
    }

    @Test
    public void create() {
        Vehicle vehicle = crud.create(1, 2012, "Honda", "Concord");
        assertNotNull(vehicle);
        assertNotEquals(vehicle, testVehicle);
        // create a vehicle with a taken-id
        Vehicle vehicle2_fail = crud.create(1, 2020, "Toyota", "Prius");
        assertNull(vehicle2_fail);

        Vehicle vehicle2_success = crud.create(2, 2020, "Toyota", "Prius");
        assertNotNull(vehicle2_success);
        assertNotEquals(vehicle, vehicle2_success);

        // invalid year
        Vehicle vehicle3_fail = crud.create(3, 2051, "Future", "Car");
        assertNull(vehicle3_fail);

        // invalid make
        Vehicle vehicle4_fail = crud.create(4, 2010, "", "UnknownModel");
        assertNull(vehicle4_fail);

        // invalid model (blank/spaces)
        Vehicle vehicle5_fail = crud.create(5, 2000, "UnknownMake", "     ");
        assertNull(vehicle5_fail);
    }

    @Test
    public void update() {
        // check initial information
        assertEquals(testVehicle.getId(), 0);
        assertEquals(testVehicle.getYear(), 1968);
        assertTrue(testVehicle.getMake().equals("bmw"));
        assertTrue(testVehicle.getModel().equals("cooper"));

        // update information
        crud.update(0, 10, 2021, "mini", "cooper");
        assertEquals(testVehicle.getId(), 10);
        assertEquals(testVehicle.getYear(), 2021);
        assertTrue(testVehicle.getMake().equals("mini"));
        assertTrue(testVehicle.getModel().equals("cooper"));

        boolean invalidInfo = crud.update(10, 0,1949, "", "      ");
        assertFalse(invalidInfo);

        boolean invalidID = crud.update(12345, 9,2020, "Arbitrary", "Vehicle");
        assertFalse(invalidID);
    }

    @Test
    public void getVehicles() {
        Vehicle vehicle = crud.create(100, 2012, "Honda", "Civic");
        Vehicle vehicle2 = crud.create(101, 2013, "Tesla", "S");
        ArrayList<Vehicle> expected = crud.getVehicles();
        ArrayList<Vehicle> actual = new ArrayList<>(Arrays.asList(testVehicle, vehicle, vehicle2));
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void getVehiclesById() {
        // get testVehicle
        Vehicle expected = crud.getVehiclesById(0);
        assertTrue(expected.equals(testVehicle));
        // non-existing id test
        assertNull(crud.getVehiclesById(12345));
    }

    @Test
    public void getVehiclesByMake() {
        Vehicle honda1 = crud.create(100, 2012, "Honda", "Civic");
        Vehicle honda2 = crud.create(101, 2013, "Honda", "Odyssey");
        Vehicle bmw = crud.create(102, 2016, "BMW", "X1");
        ArrayList<Vehicle> expectedHondaVehicles = crud.getVehiclesByMake("honda");
        ArrayList<Vehicle> actualHondaVehicles = new ArrayList<>(Arrays.asList(honda1, honda2));
        ArrayList<Vehicle> expectedBMWVehicles = crud.getVehiclesByMake("bmw");
        ArrayList<Vehicle> actualBMWVehicles = new ArrayList<>(Arrays.asList(testVehicle, bmw));
        assertTrue(expectedHondaVehicles.equals(actualHondaVehicles));
        assertTrue(expectedBMWVehicles.equals(actualBMWVehicles));
    }

    @Test
    public void deleteById() {
        // delete testVehicle
        boolean successfulDeletion = crud.deleteById(0);
        assertTrue(successfulDeletion);
        // delete non-existing id
        assertFalse(crud.deleteById(98765));
    }

    @After
    public void destroy(){
        crud.destructor();
        testVehicle = null;
	System.out.println("");
    }
}
