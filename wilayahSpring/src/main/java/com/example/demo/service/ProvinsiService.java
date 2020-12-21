package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProvinsiDto;
import com.example.demo.entity.ProvinsiEntity;

public interface ProvinsiService {
	List<ProvinsiEntity> getProvinsi();
	ProvinsiEntity insertProvinsi(ProvinsiDto dto);
	ProvinsiEntity deleteProvinsi(Integer id);
	ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto dto);
}
