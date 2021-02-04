CLASS = VehicleCRUD.class
TEST_CLASS = VehicleCRUDTestRunner.class

.PHONY: all clean

all: ${CLASS}

test: ${TEST_CLASS}
	
VehicleCRUD.class: VehicleCRUD.java Vehicle.java Demo.java VehicleCRUDTest.java VehicleCRUDTestRunner.java
	javac Vehicle.java VehicleCRUD.java Demo.java

VehicleCRUDTestRunner.class: VehicleCRUD.java Vehicle.java VehicleCRUDTest.java VehicleCRUDTestRunner.java
	javac -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar -d classes VehicleCRUDTestRunner.java VehicleCRUDTest.java VehicleCRUD.java Vehicle.java
	
run:
	java Demo

testrun:
	java -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:classes/:.\ org.junit.runner.JUnitCore VehicleCRUDTestRunner

clean:
	rm -f *.class
	rm classes -r

