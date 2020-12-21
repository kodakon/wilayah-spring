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
@Table(name="kabupaten_entity")
@Data
public class KabupatenEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kodeKabupaten", length = 50, unique = true, nullable = false)
	private String kodeKabupaten;
	
	@Column(name = "namaKabupaten", length = 50, nullable =false)
	private String namaKabupaten;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity provinsiEntity;

	public KabupatenEntity(Integer id, String kodeKabupaten, String namaKabupaten, Integer status,
			ProvinsiEntity provinsiEntity) {
		super();
		this.id = id;
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.status = status;
		this.provinsiEntity = provinsiEntity;
	}

	public KabupatenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
