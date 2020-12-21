package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.KecamatanDto;
import com.example.demo.entity.KabupatenEntity;
import com.example.demo.entity.KecamatanEntity;
import com.example.demo.entity.ProvinsiEntity;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.KecamatanRepository;
import com.example.demo.repository.ProvinsiRepository;

@Service
@Transactional
public class KecamatanServicempl implements KecamatanService {

	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	public KecamatanEntity convertToKecamatanEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setStatus(1);
		return kecamatanEntity;
	}
	
	
	@Override
	public List<KecamatanEntity> getKecamatan() {
		// TODO Auto-generated method stub
		return kecamatanRepository.findId();
	}
	
	@Override
	public List<KecamatanEntity> getKecamatanByKabupaten(String kodeKabupaten) {
		// TODO Auto-generated method stub
		return kecamatanRepository.findByKodeKabupaten(kodeKabupaten);
	}
	
	@Override
	public List<KecamatanEntity> getKecamatanByProvinsi(String kodeProvinsi) {
		// TODO Auto-generated method stub
		return kecamatanRepository.findByKodeProvinsi(kodeProvinsi);
	}

	@Override
	public KecamatanEntity insertKecamatan(KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = convertToKecamatanEntity(dto);
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity deleteKecamatan(Integer id) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		kecamatanEntity.setStatus(0);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(id).get();
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}

}
