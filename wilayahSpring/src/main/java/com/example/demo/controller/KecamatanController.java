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
import com.example.demo.dto.KecamatanDto;
import com.example.demo.dto.StatusMessageDto;
import com.example.demo.entity.KabupatenEntity;
import com.example.demo.entity.KecamatanEntity;
import com.example.demo.service.KecamatanServicempl;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	
	@Autowired
	private KecamatanServicempl kecamatanService;
	
	@GetMapping("/get-kecamatan")
	public ResponseEntity<?> getKecamatan(){
		return ResponseEntity.ok(kecamatanService.getKecamatan());
	}
	
	@GetMapping("/get-kecamatan-kabupaten/{kodeKabupaten}")
	public ResponseEntity<?> getKecamatanByKabupaten(@PathVariable String kodeKabupaten){
		return ResponseEntity.ok(kecamatanService.getKecamatanByKabupaten(kodeKabupaten));
	}
	
	@GetMapping("/get-kecamatan-provinsi/{kodeProvinsi}")
	public ResponseEntity<?> getKecamatanByProvinsi(@PathVariable String kodeProvinsi){
		return ResponseEntity.ok(kecamatanService.getKecamatanByProvinsi(kodeProvinsi));
	}
	
	@PostMapping("/post-kecamatan")
	public ResponseEntity<?> postKecamatan(@RequestBody KecamatanDto dto){
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKecamatan().equals("") || dto.getKodeKecamatan().equals("") || dto.getKodeProvinsi().equals("") || dto.getKodeKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil ditambahkan");
			result.setData(kecamatanService.insertKecamatan(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete-kecamatan/{id}")
	public ResponseEntity<?> deleteKecamatan(@PathVariable Integer id){
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		
		result.setStatus(HttpStatus.BAD_REQUEST.value());
		result.setMessage("Data terhapus");
		result.setData(kecamatanService.deleteKecamatan(id));
		return ResponseEntity.ok(result);
		
	}
		
	@PutMapping("/update-kecamatan/{id}")
	public ResponseEntity<?> updateKecamatan(@PathVariable Integer id, @RequestBody KecamatanDto dto){
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKecamatan().equals("") || dto.getKodeKecamatan().equals("") || dto.getKodeProvinsi().equals("") || dto.getKodeKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil diubah");
			result.setData(kecamatanService.updateKecamatan(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
}
