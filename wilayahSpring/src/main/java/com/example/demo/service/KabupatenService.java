package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.KabupatenDto;
import com.example.demo.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getKabupaten();
	KabupatenEntity insertKabupaten(KabupatenDto dto);
	KabupatenEntity deleteKabupaten(Integer id);
	KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto);
	
}
