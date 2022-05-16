package com.eljc.carsale.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eljc.carsale.model.Models;

public interface ModelsRepository extends JpaRepository<Models, Long>{
	
	Page<Models> findByMakeId(Long id, Pageable pagination);

}
