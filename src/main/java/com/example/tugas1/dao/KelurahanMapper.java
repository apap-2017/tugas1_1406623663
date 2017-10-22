package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.KelurahanModel;

@Mapper
public interface KelurahanMapper {

	@Select("select * from kelurahan where kelurahan.id=#{id}")
	KelurahanModel selectKelurahan(@Param("id") int id);
}
