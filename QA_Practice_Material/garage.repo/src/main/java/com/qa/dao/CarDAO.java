package com.qa.dao;

import java.util.ArrayList;
import java.util.List;
import com.qa.utils.Garage;
import com.qa.vehicles.Vehicle;
import com.qa.vehicles.Car;

public class CarDAO implements Dao {

	// This method checks if an garage exists, if it does it returns it in an garage
	// list.
	Garage garage = Garage.getInstance();

	// This method is called upon to change vehicle object to a car object.
	public Car modelFromVehicle(Vehicle vehicle) {
		return (Car) vehicle;
	}

	// this method can be called by the controller to add a vehicle to the garage.
	public Car create(Vehicle vehicle) {
		garage.add(vehicle);
		return (Car) vehicle;
	}

	public Car read(int id) {
		Vehicle convert = garage.searchCar(id);
		Car carConverted = modelFromVehicle(convert);
		return carConverted;
	}

	public List<Car> readAll() {
		List<Vehicle> newList = garage.searchGarage("Car");
		List<Car> convertedList = new ArrayList<Car>();
		for (Vehicle x : newList) {
			Car car = modelFromVehicle(x);
			convertedList.add(car);
		}
		return convertedList;
	}

	public boolean delete(int id) {
		boolean answer = garage.removeVehicleById(id);
		return answer;
	}

}
