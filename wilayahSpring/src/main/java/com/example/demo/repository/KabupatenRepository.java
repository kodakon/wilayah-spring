package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	
	@Query(value = "select * from kabupaten_entity where status = 1", nativeQuery = true)
	List<KabupatenEntity> findId();
		
	@Query(value = "select * from kabupaten_entity where kode_provinsi = ?", nativeQuery = true)
	List<KabupatenEntity> findByKodeProvinsi(String kodeProvinsi);
	
	KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
}
