CLASS = VehicleCRUD.class 
.PHONY: all clean

all: ${CLASS}
	
VehicleCRUD.class: VehicleCRUD.java VehicleCRUDTest.java Vehicle.java Demo.java
	javac -cp ./src/junit-4.12.jar;. Vehicle.java VehicleCRUD.java VehicleCRUDTest.java Demo.java

run: ${CLASS}
	java Demo

clean:
	rm -f *.class

