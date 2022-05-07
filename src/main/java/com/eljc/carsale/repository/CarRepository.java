package com.eljc.carsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eljc.carsale.model.Vehicle;

public interface CarRepository extends JpaRepository<Vehicle, Long>{
	

}
