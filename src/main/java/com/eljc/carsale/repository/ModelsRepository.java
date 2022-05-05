package com.eljc.carsale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eljc.carsale.model.Models;

public interface ModelsRepository extends JpaRepository<Models, Long>{
	
	List<Models> findByMakeId(Long id);

}
