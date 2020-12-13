package com.qa.menu;
//Controllers 
import com.qa.controllers.GarageController; //Interface 
import com.qa.controllers.CarController;
import com.qa.controllers.MotorcycleController;
import com.qa.controllers.TruckController;
//Data Access Object
import com.qa.dao.CarDAO;
import com.qa.dao.MotorcycleDAO;
import com.qa.dao.TruckDAO;
//Scanner Class
import com.qa.utils.UserInput;

public class Menu {
	// Instantiation: The new keyword is a Java operator that creates the object.
	UserInput input = new UserInput();

	GarageController<?> active;

	// Declaration: to store objects.
	CarController carController;
	MotorcycleController motorcycleController;
	TruckController truckController;

	// Constructor
	public Menu() {

		// Instantiation: for concrete (has implemented methods) class.
		CarDAO carDao = new CarDAO();
		carController = new CarController(carDao);

		MotorcycleDAO motorcycleDao = new MotorcycleDAO();
		motorcycleController = new MotorcycleController(motorcycleDao);

		TruckDAO truckDao = new TruckDAO();
		truckController = new TruckController(truckDao);

	}
	//This method will be invoked by runner main method. 
	public void start() {
		boolean exit = false;
		do {
			System.out.println("(1) for Car");
			System.out.println("(2) for Motorcycle");
			System.out.println("(3) for Truck");

			int selection = input.getInt();

			switch (selection) {
			case 1:
				active = carController;
				action();
				break;
			case 2:
				active = motorcycleController;
				action();
				break;
			case 3:
				active = truckController;
				action();
				break;
			case 4:
				exit = true;
			}
		} while (!exit);
	}
	
	//This method will be invoked by start method. 
	public void action() {
		boolean exit = false;
		do {
			System.out.println("What do you want to do?");
			System.out.println("1 = Create");
			System.out.println("2 = Read");
			System.out.println("3 = Read All");
			System.out.println("4 = Update");
			System.out.println("5 = Delete");

			int selection = input.getInt();

			switch (selection) {
			case 1:
				active.create();
				break;
			case 2:
				active.read();
				break;
			case 3:
				active.readAll();
				break;
			case 4:
				active.update();
				break;
			case 5:
				active.delete();
				break;
			case 6:
				exit = true;
			}
		} while (!exit);
	}
}
