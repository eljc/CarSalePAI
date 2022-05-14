package com.eljc.carsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eljc.carsale.model.Vehicle;
import com.eljc.carsale.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@GetMapping
	public Page<Vehicle> list(@RequestParam(required = false) String nameCar, @RequestParam int page,
			@RequestParam int qtd, @RequestParam(required = false) String order) {

		Pageable pagination = PageRequest.of(page, qtd, Direction.ASC);

		Page<Vehicle> vehicles = carRepository.findAll(pagination);

		return vehicles;
	}

	// paginação mais simples
	// page=0&size=10&sort=id,desc
	// caso não passe os campos de ordena usa o @PagebleDefault
/*	@Cacheable(value = "lisCar")
	@GetMapping
	public Page<Vehicle> listPagination(@RequestParam(required = false) String nameCar,
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable pagination) {

		Page<Vehicle> vehicles = carRepository.findAll(pagination);

		return vehicles;
	}
*/	
}
