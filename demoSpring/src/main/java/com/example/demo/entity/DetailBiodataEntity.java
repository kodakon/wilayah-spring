package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "domisili",length = 50, nullable = false)
	private String domisili;
	
	@Column(name = "usia",length = 50, nullable = false)
	private Integer usia;
	
	@Column(name = "tanggal_lahir",length = 50, nullable = false)
	private Date tanggalLahir;
	
	@Column(name = "hobi",length = 50, nullable = false)
	private String hobi;
	
	@Column(name = "jenis_kelamin",length = 50, nullable = false)
	private String jenisKelamin;

	public DetailBiodataEntity(Integer id, String domisili, Integer usia, Date tanggalLahir, String hobi,
			String jenisKelamin) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
	}
	
	public DetailBiodataEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomisili() {
		return domisili;
	}

	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}

	public Integer getUsia() {
		return usia;
	}

	public void setUsia(Integer usia) {
		this.usia = usia;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	
}
