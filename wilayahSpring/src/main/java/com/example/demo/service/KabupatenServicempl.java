package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.KabupatenDto;

import com.example.demo.entity.KabupatenEntity;
import com.example.demo.entity.ProvinsiEntity;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServicempl implements KabupatenService {
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setStatus(1);
		return kabupatenEntity;
	}

	@Override
	public List<KabupatenEntity> getKabupaten() {
		// TODO Auto-generated method stub
		return kabupatenRepository.findId();
	}

	@Override
	public KabupatenEntity insertKabupaten(KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity deleteKabupaten(Integer id) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		kabupatenEntity.setStatus(0);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		ProvinsiEntity provinsiEntity =  provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}
	
	
}
