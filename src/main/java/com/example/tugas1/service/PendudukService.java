package com.example.tugas1.service;

import java.util.List;

import com.example.tugas1.model.PendudukModel;


public interface PendudukService {
	//fitur1
	PendudukModel selectPenduduk(String nik);

	List<PendudukModel> selectAllPenduduk ();
	
	//fitur3
	void addPenduduk (PendudukModel penduduk);

	void updatePendudukWafat(String nik);
	 
	//fitur5
	// void updatePenduduk (PendudukModel penduduk);
}
