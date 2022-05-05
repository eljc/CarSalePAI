package com.eljc.carsale.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eljc.carsale.model.BodyStyle;
import com.eljc.carsale.model.Makes;
import com.eljc.carsale.model.Models;
import com.eljc.carsale.repository.MakesRepository;

public class ModelForm {
	
	@NotNull @NotEmpty @Size(min = 2)
	private String name;
	
	@NotNull @NotEmpty 
	private BodyStyle style;
	
	@NotNull @NotEmpty 
	private Long idMake;

	public Models converter(MakesRepository makeRepository) {
		Optional<Makes> make = makeRepository.findById(idMake);		
		return new Models(name, style, make.get());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BodyStyle getStyle() {
		return style;
	}

	public void setStyle(BodyStyle style) {
		this.style = style;
	}

	public Long getIdMake() {
		return idMake;
	}

	public void setIdMake(Long idMake) {
		this.idMake = idMake;
	}			
}
