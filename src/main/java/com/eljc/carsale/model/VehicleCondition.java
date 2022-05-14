package com.eljc.carsale.model;

import java.util.stream.Stream;

public enum VehicleCondition {

	NEW(1), USED(2);
	
	private int vehicleCondition;
	
	private VehicleCondition(int vehicleCondition) {
		this.vehicleCondition = vehicleCondition;
	}
	
	public int getVehicleCondition() {
		return vehicleCondition;
	}
	
	public static VehicleCondition of(int vehicleCondition) {
        return Stream.of(VehicleCondition.values())
          .filter(p -> p.getVehicleCondition() == vehicleCondition)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
	
}
