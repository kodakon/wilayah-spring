package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProvinsiDto;
import com.example.demo.dto.StatusMessageDto;
import com.example.demo.entity.ProvinsiEntity;
import com.example.demo.service.ProvinsiServicempl;

@RestController
@RequestMapping("/provinsi")
public class ProvinsiController {
	
	@Autowired
	private ProvinsiServicempl provinsiService;
	
	@GetMapping("/get-provinsi")
	public ResponseEntity<?> getProvinsi(){
		return ResponseEntity.ok(provinsiService.getProvinsi());
	}
	
	@PostMapping("/post-provinsi")
	public ResponseEntity<?> postProvinsi(@RequestBody ProvinsiDto dto){
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaProvinsi().equals("") || dto.getKodeProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil ditambahkan");
			result.setData(provinsiService.insertProvinsi(dto));
			return ResponseEntity.ok(result);
		}
		
	}
	
	@DeleteMapping("/delete-provinsi/{id}")
	public ResponseEntity<?> deleteProvinsi(@PathVariable Integer id){
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		
		result.setStatus(HttpStatus.BAD_REQUEST.value());
		result.setMessage("Data terhapus");
		result.setData(provinsiService.deleteProvinsi(id));
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/update-provinsi/{id}")
	public ResponseEntity<?> updateProvinsi(@PathVariable Integer id, @RequestBody ProvinsiDto dto){
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaProvinsi().equals("") || dto.getKodeProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil ditambahkan");
			result.setData(provinsiService.updateProvinsi(id, dto));
			return ResponseEntity.ok(result);
		}
	}
}
