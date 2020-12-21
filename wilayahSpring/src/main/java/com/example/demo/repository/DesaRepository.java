package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DesaEntity;
import com.example.demo.entity.KecamatanEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer>{
	@Query(value = "select * from desa_entity where status = 1", nativeQuery = true)
	List<DesaEntity> findId();
		
	@Query(value = "select * from desa_entity where kode_provinsi = ?", nativeQuery = true)
	List<DesaEntity> findByKodeProvinsi(String kodeProvinsi);
	
	@Query(value = "select * from desa_entity where kode_kabupaten = ?", nativeQuery = true)
	List<DesaEntity> findByKodeKabupaten(String kodeKabupaten);
	
	@Query(value = "select * from desa_entity where kode_kecamatan = ?", nativeQuery = true)
	List<DesaEntity> findByKodeKecamatan(String kodeKecamatan);
	
	DesaEntity findByKodeDesa(String kodeDesa);
}
