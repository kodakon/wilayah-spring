package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {

	@Query(value = "select * from provinsi_entity where status = 1", nativeQuery = true)
	List<ProvinsiEntity> findId();
	
	@Query(value = "select * from provinsi_entity where kode_provinsi = ?", nativeQuery = true)
	List<ProvinsiEntity> findIdProvinsi(String kodeProvinsi);
	
	ProvinsiEntity findByKodeProvinsi(String kodeProvinsi);
}