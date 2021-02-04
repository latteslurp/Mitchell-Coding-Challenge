# Mitchell SDE Intern Coding Challenge
Hello! This is a CRUD implementation on the Vehicle class, Mitchell SDE Intern Coding Challenge.

The vehicle class has 4 instances:
- ID (as an integer) -> each object should have a unique ID
- Year (as an integer) -> each object should hold a valid year (1950 - 2050)
- Make (as a string) -> each object cannot have an empty string/null/empty spaces
- Model (as a string) -> each object cannot have an empty string/null/empty spaces

In the VehicleCRUD, there are 6 main implementations:
- Create: Create a vehicle object, if all of the "given "inputs are valid. (return Vehicle)
- Update: Update an existing Vehicle object/previously created Vehicle object, if all of the given inputs are valid. (return boolean)
- Get Vehicles: Get a list of all of the existing Vehicle objects. (return ArrayList)
- Get Vehicle by ID: Get an existing Vehicle object that matches the ID given from the user input. (return Vehicle)
- Get Vehicles by Make: Get a list of all Vehicle objects that matches the given Make input from the user. (return ArrayList)
- Delete Vehicle by ID: Delete/remove an existing Vehicle object by a matching ID given from the user input. (return boolean)
Within the VehicleCRUD, all existing Vehicles Object are stored in a HashMap, where the id acts as the item's key and the Vehicle object as the item's value.

Each of the method above is being tested independently with JUnit, on the VehicleCRUDTest file.

On top of that, there is a Demo file (contains main method) that allows us to see all of the operations working together in action!

## To run the program:
- run `make` to compile the program.
- run `make run` to run the Demo file.

## To run test of the program:
- run `make test` to compile test files.
- run `make testrun` to run the test.
