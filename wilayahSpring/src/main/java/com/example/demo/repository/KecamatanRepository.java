package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.KecamatanEntity;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer> {
	
	@Query(value = "select * from kecamatan_entity where status = 1", nativeQuery = true)
	List<KecamatanEntity> findId();
		
	@Query(value = "select * from kecamatan_entity where kode_provinsi = ?", nativeQuery = true)
	List<KecamatanEntity> findByKodeProvinsi(String kodeProvinsi);
	
	@Query(value = "select * from kecamatan_entity where kode_kabupaten = ?", nativeQuery = true)
	List<KecamatanEntity> findByKodeKabupaten(String kodeKabupaten);
	
	KecamatanEntity findByKodeKecamatan(String kodeKecamatan);
}
