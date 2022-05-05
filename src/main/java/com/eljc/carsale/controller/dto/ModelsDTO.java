package com.eljc.carsale.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.eljc.carsale.model.Models;

public class ModelsDTO {

	private Long id;

	private String name;

	public ModelsDTO(Models model) {
		this.id = model.getId();
		this.name = model.getModelName();
	}

	public static List<ModelsDTO> converter(List<Models> models) {
		return models.stream().map(ModelsDTO::new).collect(Collectors.toList());
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

}
