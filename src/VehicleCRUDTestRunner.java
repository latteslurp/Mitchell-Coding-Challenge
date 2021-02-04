import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class VehicleCRUDTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(VehicleCRUDTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("\nTEST IS SUCCESSFUL: " + result.wasSuccessful());
    }
}
