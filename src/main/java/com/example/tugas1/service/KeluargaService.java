package com.example.tugas1.service;

import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.PendudukModel;

public interface KeluargaService {
	KeluargaModel selectKeluarga(String nomor_kk);
	KeluargaModel selectKeluarga2(int id_keluarga);
	KeluargaModel selectKeluargaDanAnggota(String nomor_kk);
}
