package com.qa.controllers;

//Interface
import com.qa.vehicles.Vehicle;
//Importing original class 
import com.qa.vehicles.Truck;
import com.qa.dao.TruckDAO;
//
import java.util.List;
import com.qa.utils.UserInput;

public class TruckController implements GarageController {

	UserInput input = new UserInput();
	private TruckDAO truckDao;

	public TruckController(TruckDAO truckDao) {
		this.truckDao = truckDao;
	}

	public Vehicle create() {
		// Asks
		System.out.println("what is the brand?");
		String brand = input.getString();
		//
		System.out.println("what colour is it?");
		String colour = input.getString();
		//
		System.out.println("what is the cabinType?");
		String cabinType = input.getString();
		//
		Truck fredo = new Truck(brand, colour, cabinType);
		//
		Truck truck = truckDao.create(fredo);
		//
		System.out.println(truck.toString());
		//
		return truck;

	}

	public Truck read() {
		System.out.println("What is the ID?");
		int id = input.getInt();
		Truck truck = truckDao.read(id);
		return truck;
	}

	public List<Truck> readAll() {
		List<Truck> truck = truckDao.readAll();
		for (Truck x : truck) {
			System.out.println(x.toString());
		}
		return truck;
	}

	public Truck update() {
		System.out.println("what is the id of the car you want to delete?");
		int id = input.getInt();
		// Asks
		System.out.println("what is the brand?");
		String brand = input.getString();
		//
		System.out.println("what colour is it?");
		String colour = input.getString();
		//
		System.out.println("what is the cabinType?");
		String cabinType = input.getString();
		//
		Truck fredo = new Truck(brand, colour, cabinType);

		if (truckDao.delete(id)) {
			return truckDao.create(fredo);
		} else {
			System.out.println("Failed");
			return null;
		}
	}

	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
