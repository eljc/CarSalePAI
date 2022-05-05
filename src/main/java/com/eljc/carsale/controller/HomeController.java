package com.eljc.carsale.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eljc.carsale.controller.dto.MakesDTO;
import com.eljc.carsale.controller.dto.ModelsDTO;
import com.eljc.carsale.controller.form.ModelForm;
import com.eljc.carsale.model.Makes;
import com.eljc.carsale.model.Models;
import com.eljc.carsale.repository.MakesRepository;
import com.eljc.carsale.repository.ModelsRepository;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private MakesRepository makesRepository;
	
	@Autowired
	private ModelsRepository modelsRepository;
	
	@GetMapping
	public List<MakesDTO> listMakes(){
		
		List<Makes> makes =  makesRepository.findAll();
		
		return MakesDTO.converter(makes);
	}

	@GetMapping("/{id}")
	public List<ModelsDTO> listModels(@PathVariable Long id){
				
		return ModelsDTO.converter(modelsRepository.findByMakeId(id));
	}
	@PostMapping
	@Transactional
	public ResponseEntity<ModelsDTO> inserModel(@RequestBody @Valid ModelForm form, UriComponentsBuilder uriBuilder) {
		Models model = form.converter(makesRepository);
		modelsRepository.save(model);
		
		URI uri = uriBuilder.path("/models/{id}").buildAndExpand(model.getId()).toUri();
		return ResponseEntity.created(uri).body(new ModelsDTO(model));
	}
	
	/*
	@PostMapping
	@Transactional
	public ResponseEntity<ModelDTO> cadastrarModel(@RequestBody @Valid ModelForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	*/
}
