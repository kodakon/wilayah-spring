package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesaDto {
	private String kodeDesa;
	private String namaDesa;
	private String kodeKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
}
