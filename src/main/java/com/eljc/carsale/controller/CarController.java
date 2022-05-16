package com.eljc.carsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eljc.carsale.controller.dto.MakesDTO;
import com.eljc.carsale.controller.dto.ModelsDTO;
import com.eljc.carsale.model.Makes;
import com.eljc.carsale.model.Models;
import com.eljc.carsale.model.Vehicle;
import com.eljc.carsale.repository.CarRepository;
import com.eljc.carsale.repository.MakesRepository;
import com.eljc.carsale.repository.ModelsRepository;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private MakesRepository makeRepository;
	
	@Autowired
	private ModelsRepository modelRepository;
	

	@GetMapping
	public Page<Vehicle> list(@RequestParam(required = false) String nameCar, @RequestParam int page,
			@RequestParam int qtd, @RequestParam(required = false) String order) {

		Pageable pagination = PageRequest.of(page, qtd, Direction.ASC);

		Page<Vehicle> vehicles = carRepository.findAll(pagination);

		return vehicles;
	}


	@GetMapping("/makes")
	@CacheEvict(value = "listMakes", allEntries = true)
	public Page<MakesDTO> listMakes(@RequestParam(required = false) String makeName, 
			@PageableDefault(sort = "makeName", direction = Direction.DESC, page = 0, size = 10 ) Pageable pagination){
		if(makeName == null) {
			Page<Makes> makePages = makeRepository.findAll(pagination);
			return MakesDTO.converter(makePages);
		}else {
			Page<Makes> makePages = makeRepository.findByMakeName(makeName, pagination);
			return MakesDTO.converter(makePages);
		}
		 
	}
	
	@PutMapping("/models")
	@CacheEvict(value = "listModelsPut", allEntries = true)
	public Page<ModelsDTO> listModelsPut(@RequestParam(required = false) Long idMake, 
			@PageableDefault(sort = "modelName", direction = Direction.DESC, page = 0, size = 10 ) Pageable pagination){
		
		Page<Models> modelPage = modelRepository.findByMakeId(idMake, pagination);
		
		return ModelsDTO.converter(modelPage);
		/*
		  if(idMake == null) {
		 
			Page<Makes> makePages = makeRepository.findAll(pagination);
			return MakesDTO.converter(makePages);
		}else {
			Page<Makes> makePages = makeRepository.findByMakeName(makeName, pagination);
			return MakesDTO.converter(makePages);
		}
		*/
		 
	}
	
	@GetMapping("/models/{id}")
	@CacheEvict(value = "listModels", allEntries = true)
	public Page<ModelsDTO> listModels(@PathVariable Long id, 
			@PageableDefault(sort = "modelName", direction = Direction.DESC, page = 0, size = 10 ) Pageable pagination){
		
		Page<Models> modelPage = modelRepository.findByMakeId(id, pagination);
		
		return ModelsDTO.converter(modelPage);
		/*
		  if(idMake == null) {
		 
			Page<Makes> makePages = makeRepository.findAll(pagination);
			return MakesDTO.converter(makePages);
		}else {
			Page<Makes> makePages = makeRepository.findByMakeName(makeName, pagination);
			return MakesDTO.converter(makePages);
		}
		*/
		 
	}
	
	
	// paginação mais simples
	// page=0&size=10&sort=id,desc
	// caso não passe os campos de ordena usa o @PagebleDefault
	@CacheEvict(value = "listaCars", allEntries = true)	
	public Page<Vehicle> listPagination(@RequestParam(required = false) String nameCar,
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pagination) {

		Page<Vehicle> vehicles = carRepository.findAll(pagination);

		return vehicles;
	}
	
}
