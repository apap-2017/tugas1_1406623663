package com.example.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KelurahanMapper;
import com.example.tugas1.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KelurahanServiceDatabase implements KelurahanService {

	@Autowired
	KelurahanMapper kelurahanMapper;
	
	@Override
	public KelurahanModel selectKelurahan(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
