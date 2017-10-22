package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;

@Mapper
public interface KeluargaMapper {

	@Select("select * from penduduk join keluarga on keluarga.id = penduduk.id_keluarga where keluarga.nomor_kk = #{nomor_kk}")
	@Results(value = {
			@Result(property = "id", column = "id"), @Result(property = "nik", column = "nik"),
			@Result(property = "nama", column = "nama"), @Result(property = "tempat_lahir", column = "tempat_lahir"),
			@Result(property = "tanggal_lahir", column = "tanggal_lahir"),
			@Result(property = "jenis_kelamin", column = "jenis_kelamin"),
			@Result(property = "golongan_darah", column = "golongan_darah"),
			@Result(property = "agama", column = "agama"),
			@Result(property = "status_perkawinan", column = "status_perkawinan"),
			@Result(property = "pekerjaan", column = "pekerjaan"), @Result(property = "is_wni", column = "is_wni"),
			@Result(property = "is_wafat", column = "is_wafat"),
			@Result(property = "id_keluarga", column = "id_keluarga"),
			@Result(property = "kelurahannya", column = "id", javaType = KelurahanModel.class, one = @One(select = "selectKelurahannya")) })
	List<PendudukModel> selectPenduduk1(@Param("nomor_kk") String nomor_kk);

	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	@Results(value = { 
			@Result(property = "id", column = "id"), 
			@Result(property = "alamat", column = "alamat"),
			@Result(property = "RT", column = "RT"), 
			@Result(property = "RW", column = "RW"),
			@Result(property = "is_tidak_berlaku", column = "is_tidak_berlaku"),
			@Result(property = "penduduk", column = "nomor_kk", 
				javaType = List.class, 
				many = @Many(select = "selectPenduduk1")) 
			})
	KeluargaModel selectKeluargaDanAnggota(@Param("nomor_kk") String nomor_kk);
	
	@Select("select * from keluarga where id = #{id_keluarga}")
	@Results(value = {
			@Result(property="nomor_kk", column="nomor_kk"),
			@Result(property="id", column="id"),
		    @Result(property="alamat", column="alamat"),
		    @Result(property="RT", column="RT"),
		    @Result(property="RW", column="RW"),
		    @Result(property="id_kelurahan", column="id_kelurahan"),
		    @Result(property = "is_tidak_berlaku", column = "is_tidak_berlaku")})
	KeluargaModel selectKeluarga2(@Param("id_keluarga") int id_keluarga);
	
	@Select ("select nomor_kk, id, alamat, RT, RW, id_kelurahan from keluarga where nomor_kk= #{nomor_kk}")
	@Results(value = {
	@Result(property="nomor_kk", column="nomor_kk"),
	@Result(property="id", column="id"),
    @Result(property="alamat", column="alamat"),
    @Result(property="RT", column="RT"),
    @Result(property="RW", column="RW"),
	@Result(property="kelurahannya", column="id", javaType = KelurahanModel.class, one=@One (select="selectKelurahannya"))	
	})
	KeluargaModel selectKeluarga (@Param("nomor_kk")String nomor_kk);
	
	
	//Kelurahan
	@Select ("select id, id_kecamatan, nama_kelurahan from kelurahan where id= #{id_kelurahan}")
	@Results(value = {
	@Result(property="id", column="id"),
    @Result(property="nama_kelurahan", column="nama_kelurahan"),
	@Result(property="kecamatannya", column="id", javaType = KecamatanModel.class, one=@One (select="selectKecamatannya"))	
	})
	KelurahanModel selectKelurahannya (@Param("id")String id);
	
	//kecamatan
	@Select ("select id, id_kota, nama_kecamatan from kecamatan where id= #{id_kecamatan}")
	@Results(value = {
	@Result(property="id", column="id"),
    @Result(property="nama_kecamatan", column="nama_kecamatan"),
	@Result(property="kotanya", column="id", javaType = KotaModel.class, one=@One (select="selectKotanya"))	
	})
	KecamatanModel selectKecamatannya (@Param("id")String id);
	
	
	//kota
	@Select ("select id, nama_kota from kota where id= #{id_kota}")
	@Results(value = {
	@Result(property="id", column="id"),
    @Result(property="nama_kota", column="nama_kota"),	
	})
	KotaModel selectKotanya (@Param("id")String id);
}
