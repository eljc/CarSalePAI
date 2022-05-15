package com.eljc.carsale.controller.dto;

import org.springframework.data.domain.Page;

import com.eljc.carsale.model.Makes;

public class MakesDTO {
	
	private Long id;	
	private String name;
		
	public MakesDTO(Makes make) {
		this.id = make.getId();
		this.name = make.getMakeName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public static Page<MakesDTO> converter(Page<Makes> makes) {
		return makes.map(MakesDTO::new);
	}
	
}
