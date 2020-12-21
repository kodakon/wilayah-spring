package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.KecamatanDto;
import com.example.demo.entity.KecamatanEntity;

public interface KecamatanService {
	List<KecamatanEntity> getKecamatan();
	KecamatanEntity insertKecamatan(KecamatanDto dto);
	KecamatanEntity deleteKecamatan(Integer id);
	KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto);
	List<KecamatanEntity> getKecamatanByProvinsi(String kodeProvinsi);
	List<KecamatanEntity> getKecamatanByKabupaten(String kodeKabupaten);
	
}
