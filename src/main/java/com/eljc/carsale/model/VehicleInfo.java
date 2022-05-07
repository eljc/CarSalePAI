package com.eljc.carsale.model;

import java.math.BigDecimal;

public class VehicleInfo {

	public String transmission;
	
	public VehicleColor color;
	
	public VehicleFuel fuel;
	
	public String engine;
	
	public BigDecimal miles;

	
	
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public VehicleColor getColor() {
		return color;
	}

	public void setColor(VehicleColor color) {
		this.color = color;
	}

	public VehicleFuel getFuel() {
		return fuel;
	}

	public void setFuel(VehicleFuel fuel) {
		this.fuel = fuel;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public BigDecimal getMiles() {
		return miles;
	}

	public void setMiles(BigDecimal miles) {
		this.miles = miles;
	}
	
}
