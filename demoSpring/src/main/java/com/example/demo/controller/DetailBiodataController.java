package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DetailBiodataDto;
import com.example.demo.entity.DetailBiodataEntity;
import com.example.demo.repository.DetailBiodataRepository;


@RestController
@RequestMapping("/detail") //localhost:8500/detail
public class DetailBiodataController {
	
	@Autowired
	private DetailBiodataRepository detailBiodataRepository;
	
	@GetMapping("get-all")
	public List<DetailBiodataEntity> getPerson(){
		List<DetailBiodataEntity> detailEntities = detailBiodataRepository.findAll();
//		personEntities = personRepository.findByFirstName("Ajeng");
		return detailEntities;
	}
	
	@GetMapping("/response-entity")
	public ResponseEntity<?> getAll(){
		List<DetailBiodataEntity> detailEntities = detailBiodataRepository.findAll();
		return ResponseEntity.ok(detailEntities);
	}
	
	@PostMapping("/post-detail")
	public ResponseEntity<?> insertDetailBiodata(@RequestBody DetailBiodataDto dto){
		DetailBiodataEntity detailEntities = new DetailBiodataEntity();
		detailEntities.setDomisili(dto.getDomisili());
		detailEntities.setUsia(dto.getUsia());
		detailEntities.setTanggalLahir(dto.getTanggalLahir());
		detailEntities.setHobi(dto.getHobi());
		detailEntities.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataRepository.save(detailEntities);
		return ResponseEntity.ok(detailEntities);
	}
}

