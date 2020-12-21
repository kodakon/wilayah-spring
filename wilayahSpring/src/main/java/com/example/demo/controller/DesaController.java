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

import com.example.demo.dto.DesaDto;
import com.example.demo.dto.KecamatanDto;
import com.example.demo.dto.StatusMessageDto;
import com.example.demo.entity.DesaEntity;
import com.example.demo.entity.KecamatanEntity;
import com.example.demo.service.DesaServicempl;

@RestController
@RequestMapping("/desa")
public class DesaController {
	
	@Autowired
	private DesaServicempl desaService;
	
	@GetMapping("/get-desa")
	public ResponseEntity<?> getDesa(){
		return ResponseEntity.ok(desaService.getDesa());
	}
	
	@GetMapping("/get-desa-kecamatan/{kodeKecamatan}")
	public ResponseEntity<?> getDesaByKecamatan(@PathVariable String kodeKecamatan){
		return ResponseEntity.ok(desaService.getDesaByKecamatan(kodeKecamatan));
	}
	
	@GetMapping("/get-desa-kabupaten/{kodeKabupaten}")
	public ResponseEntity<?> getDesaByKabupaten(@PathVariable String kodeKabupaten){
		return ResponseEntity.ok(desaService.getDesaByKabupaten(kodeKabupaten));
	}
	
	@GetMapping("/get-desa-provinsi/{kodeProvinsi}")
	public ResponseEntity<?> getDesaByProvinsi(@PathVariable String kodeProvinsi){
		return ResponseEntity.ok(desaService.getDesaByProvinsi(kodeProvinsi));
	}
	
	@PostMapping("/post-desa")
	public ResponseEntity<?> postDesa(@RequestBody DesaDto dto){
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaDesa().equals("")|| dto.getKodeDesa().equals("") || dto.getKodeKecamatan().equals("") || dto.getKodeProvinsi().equals("") || dto.getKodeKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil ditambahkan");
			result.setData(desaService.insertDesa(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete-desa/{id}")
	public ResponseEntity<?> deleteDesa(@PathVariable Integer id){
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		
		result.setStatus(HttpStatus.BAD_REQUEST.value());
		result.setMessage("Data terhapus");
		result.setData(desaService.deleteDesa(id));
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/update-desa/{id}")
	public ResponseEntity<?> updateDesa(@PathVariable Integer id, @RequestBody DesaDto dto){
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaDesa().equals("")|| dto.getKodeDesa().equals("") || dto.getKodeKecamatan().equals("") || dto.getKodeProvinsi().equals("") || dto.getKodeKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Tidak semua data diisi");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data berhasil diubah");
			result.setData(desaService.updateDesa(id, dto));
			return ResponseEntity.ok(result);
		}
	}
}
