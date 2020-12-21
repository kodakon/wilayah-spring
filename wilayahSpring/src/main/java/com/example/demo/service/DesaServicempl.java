package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DesaDto;
import com.example.demo.entity.DesaEntity;
import com.example.demo.entity.KabupatenEntity;
import com.example.demo.entity.KecamatanEntity;
import com.example.demo.entity.ProvinsiEntity;
import com.example.demo.repository.DesaRepository;
import com.example.demo.repository.KabupatenRepository;
import com.example.demo.repository.KecamatanRepository;
import com.example.demo.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServicempl implements DesaService {

	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private DesaRepository desaRepository;
	
	public DesaEntity convertToDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setStatus(1);
		return desaEntity;
	}
	
	@Override
	public List<DesaEntity> getDesa() {
		// TODO Auto-generated method stub
		return desaRepository.findId();
	}

	@Override
	public List<DesaEntity> getDesaByKecamatan(String kodeKecamatan) {
		// TODO Auto-generated method stub
		return desaRepository.findByKodeKecamatan(kodeKecamatan);
	}

	@Override
	public List<DesaEntity> getDesaByKabupaten(String kodeKabupaten) {
		// TODO Auto-generated method stub
		return desaRepository.findByKodeKabupaten(kodeKabupaten);
	}

	@Override
	public List<DesaEntity> getDesaByProvinsi(String kodeProvinsi) {
		// TODO Auto-generated method stub
		return desaRepository.findByKodeProvinsi(kodeProvinsi);
	}

	@Override
	public DesaEntity insertDesa(DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = convertToDesaEntity(dto);
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity deleteDesa(Integer id) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaEntity.setStatus(0);
		return desaEntity;
	}

	@Override
	public DesaEntity updateDesa(Integer id, DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(id).get();
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}
	
}
