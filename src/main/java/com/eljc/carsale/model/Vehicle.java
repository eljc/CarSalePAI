package com.eljc.carsale.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Models model;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private VehicleInfo info;
	
	private String description;

	@Transient
	private VehicleCondition condition;
	
	@Basic
	private int idConditionValue;
	
	private BigDecimal price;
	
	@PostLoad
    void fillTransient() {
        if (idConditionValue > 0) {
            this.condition = VehicleCondition.of(idConditionValue);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (condition != null) {
            this.idConditionValue = condition.getVehicleCondition();
        }
    }
	
	public Vehicle() {

	}

	public Vehicle(Models model, String description, VehicleInfo info) {
		this.model = model;
		this.description = description;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
