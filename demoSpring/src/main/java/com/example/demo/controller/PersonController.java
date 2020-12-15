package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;


//BERUPA REST APINYA CRUD

@RestController
@RequestMapping("/person") //localhost:8500/person
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("get-all")
	public List<PersonEntity> getPerson(){
		List<PersonEntity> personEntities = personRepository.findAll();
//		personEntities = personRepository.findByFirstName("Ajeng");
		return personEntities;
	}
	
	@GetMapping("/response-entity")
	public ResponseEntity<?> getAll(){
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody PersonDto dto){
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
}
