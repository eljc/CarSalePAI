package com.eljc.carsale.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Models {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String modelName;
	
	@Enumerated(EnumType.STRING)
	private BodyStyle style;
	
	@ManyToOne
	private Makes make;
	
	@OneToMany
	@JoinColumn(name="make_id", nullable = false)
	private List<Vehicle> vehicle = new ArrayList<>();
	
	public Models(){
		
	}
	
	public Models(String modelName, BodyStyle style, Makes make) {
		this.modelName = modelName;
		this.style = style;
		this.make = make;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public BodyStyle getStyle() {
		return style;
	}

	public void setStyle(BodyStyle style) {
		this.style = style;
	}

	public Makes getMake() {
		return make;
	}

	public void setMake(Makes make) {
		this.make = make;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
