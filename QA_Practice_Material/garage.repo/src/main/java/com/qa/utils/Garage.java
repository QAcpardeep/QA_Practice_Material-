package com.qa.utils;
import java.util.ArrayList;
import com.qa.vehicles.Vehicle;

public class Garage {
	
	
	private static Garage instance = null;
	
	private Garage() {}
		
	public static Garage getInstance() {
		if (instance == null) {
			instance = new Garage();
		}
		return instance;
	}

	private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
	
	public void add(Vehicle vehicle) {
		garage.add(vehicle);
	}
	
	public boolean removeVehicleById(int id) {
		garage.removeIf(Vehicle -> Vehicle.getId() == id);
		return true;
	}
	
	public ArrayList<Vehicle> searchGarage(String type) {
		ArrayList<Vehicle> found = new ArrayList<Vehicle>();
		for(Vehicle vehicle: garage) {
			if(vehicle.getType().equals(type)) {
				found.add(vehicle);
			}
		}
		return found;
	}
	
	public Vehicle searchCar(int id) {
		for(Vehicle vehicle: garage) {
			if(vehicle.getId() == id) {
				return vehicle;
			}
		}
		return null;
	}

}
