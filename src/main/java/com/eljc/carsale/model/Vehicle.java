package com.eljc.carsale.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Models model;
	
	private BigDecimal price;
	
	private String description;
	
	private VehicleCondition condition;
	
	private VehicleInfo info;
	
	public Vehicle() {
		
	}
	
	public Vehicle(Models model, BigDecimal price, String description, VehicleCondition condition, VehicleInfo info) {
		this.model = model;
		this.price = price;
		this.description = description;
		this.condition = condition;
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VehicleCondition getCondition() {
		return condition;
	}

	public void setCondition(VehicleCondition condition) {
		this.condition = condition;
	}

	public VehicleInfo getInfo() {
		return info;
	}

	public void setInfo(VehicleInfo info) {
		this.info = info;
	}

}
