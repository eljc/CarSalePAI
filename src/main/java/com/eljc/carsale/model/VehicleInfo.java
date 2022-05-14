package com.eljc.carsale.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class VehicleInfo {

	@Id
	@Column(name = "vehicle_id")
	private Long idInfo;

	@OneToOne
	@MapsId
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	public String transmission;

	public VehicleColor color;

	public VehicleFuel fuel;

	public String engine;

	public BigDecimal miles;

	public Long getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(Long idInfo) {
		this.idInfo = idInfo;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

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
