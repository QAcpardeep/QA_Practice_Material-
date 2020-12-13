package com.qa.garage;

public class Motorcycle extends Vehicle{
	private int engineSize;
	
	public Motorcycle(String brand, String colour, int engineSize) {
		super(brand, colour);
		this.engineSize = engineSize;
		this.type = "Motocycle"; 
		
	}
	
	@Override
	public double cost() {
		return this.getId()+25;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	@Override
	public String toString() {
		return "Motorcycle [engineSize=" + engineSize + " " + "]";
	}
	
	
	
}
