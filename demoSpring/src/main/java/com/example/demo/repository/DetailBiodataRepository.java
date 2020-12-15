package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DetailBiodataEntity;

@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer>{

	@Query(value = "select * from detail_biodata_entity where domisili = ?", nativeQuery = true)
	List<DetailBiodataEntity> findByDomisili(String domisili);
}
