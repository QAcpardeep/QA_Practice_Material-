package com.qa.controllers;

//Interface
import com.qa.vehicles.Vehicle;
import com.qa.vehicles.Car;
//Importing original class 
import com.qa.vehicles.Motorcycle;
import com.qa.dao.MotorcycleDAO;
//
import java.util.List;
import com.qa.utils.UserInput;

public class MotorcycleController implements GarageController {

	UserInput input = new UserInput();
	private MotorcycleDAO motorcycleDao;

	// Constructor which takes in an object of Motorcycle data access object which
	// has been assigned information.
	public MotorcycleController(MotorcycleDAO motorcycleDao) {
		this.motorcycleDao = motorcycleDao;
	}

	public Vehicle create() {
		// Asks
		System.out.println("what is the brand?");
		String brand = input.getString();
		//
		System.out.println("what colour is it?");
		String colour = input.getString();
		//
		System.out.println("What is the engien size?");
		int engineSize = input.getInt();
		//
		Motorcycle fredo = new Motorcycle(brand, colour, engineSize);
		//
		Motorcycle motorcycle = motorcycleDao.create(fredo);
		//
		System.out.println(motorcycle.toString());
		//
		return motorcycle;
	}

	public Motorcycle read() {
		System.out.println("What is the ID?");
		int id = input.getInt();
		Motorcycle motorcycle = motorcycleDao.read(id);
		System.out.println(motorcycle.toString());
		return motorcycle;
	}

	public List<Motorcycle> readAll() {
		List<Motorcycle> motorcycles = motorcycleDao.readAll();
		for (Motorcycle x : motorcycles) {
			System.out.println(x.toString());
		}
		return motorcycles;
	}

	public Motorcycle update() {
		System.out.println("what is the id of the car you want to delete?");
		int id = input.getInt();

		// Asks
		System.out.println("what is the brand?");
		String brand = input.getString();
		//
		System.out.println("what colour is it?");
		String colour = input.getString();
		//
		System.out.println("What engine size?");
		int engineSize = input.getInt();
		//
		Motorcycle fredo = new Motorcycle(brand, colour, engineSize);

		if (motorcycleDao.delete(id)) {
			return motorcycleDao.create(fredo);
		} else {
			System.out.println("Failed");
			return null;
		}
	}

	public boolean delete() {
		System.out.println("what is the id of the car you want to delete?");
		int id = input.getInt();
		if (id != 0) {
			boolean answer = motorcycleDao.delete(id);
			return answer;

		} else {
			return false;
		}
	}

}
