package com.example.tugas1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tugas1.dao.PendudukMapper;
import com.example.tugas1.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {

	@Autowired
	private PendudukMapper pendudukMapper;
	
	//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PendudukServiceDatabase.class);
	@Override
	public PendudukModel selectPenduduk(String nik) {
		log.info ("Masukkan Nomor Induk Kependudukan {}", nik);
        return pendudukMapper.selectPenduduk (nik);
	}
	@Override
	public List<PendudukModel> selectAllPenduduk() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addPenduduk(PendudukModel penduduk) {
		// TODO Auto-generated method stub
		
	}
	
}
