package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DesaDto;
import com.example.demo.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getDesa();
	List<DesaEntity> getDesaByKecamatan(String kodeKecamatan);
	List<DesaEntity> getDesaByKabupaten(String kodeKabupaten);
	List<DesaEntity> getDesaByProvinsi(String kodeProvinsi);
	DesaEntity insertDesa(DesaDto dto);
	DesaEntity deleteDesa(Integer id);
	DesaEntity updateDesa(Integer id, DesaDto dto);
}
