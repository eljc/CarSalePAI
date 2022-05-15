package com.eljc.carsale.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eljc.carsale.model.Makes;

public interface MakesRepository extends JpaRepository<Makes, Long>{

	Page<Makes> findByMakeName(String makeName, Pageable pagination);
		

	
}
