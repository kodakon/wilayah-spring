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

import com.example.demo.dto.KabupatenDto;
import com.example.demo.dto.StatusMessageDto;
import com.example.demo.entity.KabupatenEntity;
import com.example.demo.service.KabupatenServicempl;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	
	@Autowired
	private KabupatenServicempl kabupatenService;
	
	@GetMapping("/get-kabupaten")
	public ResponseEntity<?> getKabupaten(){
		return ResponseEntity.ok(kabupatenService.getKabupaten());
	}
	
	@PostMapping("/post-kabupaten")
	public ResponseEntity<?> postKabupaten(@RequestBody KabupatenDto dto){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("") || dto.getKodeKabupaten().equals("") || dto.getKodeProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil ditambahkan");
			result.setData(kabupatenService.insertKabupaten(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete-kabupaten/{id}")
	public ResponseEntity<?> deleteKabupaten(@PathVariable Integer id){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		result.setStatus(HttpStatus.BAD_REQUEST.value());
		result.setMessage("Data terhapus");
		result.setData(kabupatenService.deleteKabupaten(id));
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/update-kabupaten/{id}")
	public ResponseEntity<?> updateKabupaten(@PathVariable Integer id, @RequestBody KabupatenDto dto){
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("") || dto.getKodeKabupaten().equals("") || dto.getKodeProvinsi().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil diubah");
			result.setData(kabupatenService.updateKabupaten(id, dto));
			return ResponseEntity.ok(result);
		}
	}
}
