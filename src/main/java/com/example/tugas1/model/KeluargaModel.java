package com.example.tugas1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeluargaModel {
	private int id;
	private int nomor_kk;
	private String alamat;
	private String RT;
	private String RW;
	private int id_kelurahan;
	private int is_tidak_berlaku;
	private KelurahanModel kelurahannya;
	private KecamatanModel kecamatannya;
	private KotaModel kotanya;
}
