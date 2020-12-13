package com.qa.garage;

public class Truck extends Vehicle {
	private String cabinType;
	
	public Truck(String brand, String colour, String cabinType) {
		super(brand, colour);
		this.cabinType = cabinType;
		this.type = "Truck";
	}
	@Override
	public double cost() {
		return this.getId()+25;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	@Override
	public String toString() {
		return "Truck [cabinType=" + cabinType + " " + "]";
	}
	
	
}
