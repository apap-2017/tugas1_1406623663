package com.example.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KeluargaMapper;
import com.example.tugas1.model.KeluargaModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService{
	@Autowired
	private KeluargaMapper keluargaMapper;
	
	//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KeluargaServiceDatabase.class);
	@Override
	public KeluargaModel selectKeluarga(String nomor_kk) {
		log.info ("Masukkan Nomor Induk Kependudukan {}", nomor_kk);
        return keluargaMapper.selectKeluarga (nomor_kk);
	}

	@Override
	public KeluargaModel selectKeluargaDanAnggota(String nomor_kk) {
		// TODO Auto-generated method stub
		return keluargaMapper.selectKeluargaDanAnggota(nomor_kk);
	}

	@Override
	public KeluargaModel selectKeluarga2(int id_keluarga) {
		// TODO Auto-generated method stub
		return keluargaMapper.selectKeluarga2(id_keluarga);
	}

}
