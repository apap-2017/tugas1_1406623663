package com.example.tugas1.service;

import java.util.List;

import com.example.tugas1.model.PendudukModel;


public interface PendudukService {
	PendudukModel selectPenduduk(String nik);
	 List<PendudukModel> selectAllPenduduk ();
	 void addPenduduk (PendudukModel penduduk);
}
