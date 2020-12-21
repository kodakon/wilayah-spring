package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProvinsiDto;
import com.example.demo.entity.ProvinsiEntity;
import com.example.demo.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServicempl implements ProvinsiService {
	
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiEntity.setStatus(1);
		return provinsiEntity;
	}

	@Override
	public List<ProvinsiEntity> getProvinsi() {
		// TODO Auto-generated method stub
		return provinsiRepository.findId();
	}

	@Override
	public ProvinsiEntity insertProvinsi(ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = convertToProvinsiEntity(dto);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity deleteProvinsi(Integer id) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setStatus(0);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	
	
}
