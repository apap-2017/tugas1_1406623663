package com.example.tugas1.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendudukModel {
	private int id;
	private String nik;
	private String nama;
	private String tempat_lahir;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private String tanggal_lahir;
	private int jenis_kelamin;
	private int is_wni;
	private int id_keluarga;
	private String agama;
	private String pekerjaan;
	private String status_perkawinan;
	private String status_dalam_keluarga;
	private String golongan_darah;
	private int is_wafat;
	private KeluargaModel keluarganya;
	private KelurahanModel kelurahannya;
	private KecamatanModel kecamatannya;
	private KotaModel kotanya;
}
	

