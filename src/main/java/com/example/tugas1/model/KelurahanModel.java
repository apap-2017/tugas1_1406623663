package com.example.tugas1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KelurahanModel {
	private int id;
	private int id_kecamatan;
	private int kode_kelurahan;
	private String nama_kelurahan;
	private int kode_pos;
	private KecamatanModel kecamatannya;
	private KotaModel kotanya;
	private KecamatanModel kecamatannya2;
	private KotaModel kotanya2;
}
