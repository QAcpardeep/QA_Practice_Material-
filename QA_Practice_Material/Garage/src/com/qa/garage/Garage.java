package com.qa.garage;
import java.util.ArrayList; 

public class Garage {
	
	private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
	
	public Garage() {
		
	}
	
	public void add(Vehicle vehicle) {
		garage.add(vehicle);
	}
	
	public void clearGarage() {
		garage.clear();
	}
	
	public void removeVehicleByType(String type) {
		garage.removeIf(Vehicle -> Vehicle.getType().equals(type));
	}
	
	public void removeVehicleById(int id) {
		garage.removeIf(Vehicle -> Vehicle.getId() == id);
	}
	
	public void checkArray() {
		for(Vehicle x: garage) {
			System.out.println("ID: "+ x.getId() + ", Brand: " + x.getBrand() + ", Colour: " + x.getColour() + "," + x.toString());
		} 
	}
}
	



	
	
	
	
	
	
	
	
	

