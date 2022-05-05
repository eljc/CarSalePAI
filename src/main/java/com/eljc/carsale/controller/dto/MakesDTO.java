package com.eljc.carsale.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<MakesDTO> converter(List<Makes> makes) {
		return makes.stream().map(MakesDTO::new).collect(Collectors.toList());
	}
	
}
