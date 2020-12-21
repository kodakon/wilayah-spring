package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="provinsi_entity")
@Data
public class ProvinsiEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kodeProvinsi", length = 50, unique = true, nullable = false)
	private String kodeProvinsi;
	
	@Column(name = "namaProvinsi", length = 50, nullable =false)
	private String namaProvinsi;
	
	@Column(name = "status")
	private Integer status;

}
