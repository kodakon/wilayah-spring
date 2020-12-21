package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="kecamatan_entity")
@Data
public class KecamatanEntity implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kodeKecamatan", length = 50, unique = true, nullable = false)
	private String kodeKecamatan;
	
	@Column(name = "namaKecamatan", length = 50, nullable =false)
	private String namaKecamatan;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity provinsiEntity;

	public KecamatanEntity(Integer id, String kodeKecamatan, String namaKecamatan, Integer status,
			KabupatenEntity kabupatenEntity, ProvinsiEntity provinsiEntity) {
		super();
		this.id = id;
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.status = status;
		this.kabupatenEntity = kabupatenEntity;
		this.provinsiEntity = provinsiEntity;
	}

	public KecamatanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
