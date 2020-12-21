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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="desa_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kodeDesa", length = 50, unique = true, nullable = false)
	private String kodeDesa;
	
	@Column(name = "namaDesa", length = 50, nullable =false)
	private String namaDesa;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kodeKecamatan", referencedColumnName = "kodeKecamatan")
	private KecamatanEntity kecamatanEntity;
	
	@ManyToOne
	@JoinColumn(name = "kodeKabupaten", referencedColumnName = "kodeKabupaten")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn(name = "kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private ProvinsiEntity provinsiEntity;
	
	
}
