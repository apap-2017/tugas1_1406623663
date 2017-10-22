package com.example.tugas1.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.PendudukModel;
import com.example.tugas1.service.KeluargaService;

@Controller
public class KeluargaController {
	@Autowired
    KeluargaService KeluargaDAO;
	
	 @RequestMapping("/keluarga")
	    public String viewPath (Model model,
	            @RequestParam(value = "nomor_kk", required = true) String nomor_kk)
	    {
	        KeluargaModel keluarga = KeluargaDAO.selectKeluarga(nomor_kk);
	        KeluargaModel anggotaKeluarga = KeluargaDAO.selectKeluargaDanAnggota(nomor_kk);

	        if (keluarga != null) {
	            model.addAttribute ("keluarga", keluarga);
	            model.addAttribute("anggotaKeluarga", anggotaKeluarga);
//	            System.out.println(penduduk);
	            return "view-keluarga";
	        } else {
//	            model.addAttribute ("nik", nik);
	            return "not-found-penduduk";
	        }
	    }
	 
	 @RequestMapping("/keluarga/tambah")
	    public String add()
	    {
	    		return "form-tambah-keluarga";
	    }
	 
//	 @RequestMapping(value="/keluarga/tambah/submit", method=RequestMethod.POST)
//	    public String addSubmit (Model model,
//	            @RequestParam(value = "alamat", required = false) String nama,
//	            @RequestParam(value = "RT", required = false) String tempat_lahir,
//	            @RequestParam(value = "RT", required = false) String tanggal_lahir,
//	            @RequestParam(value = "id_kelurahan", required = false) int jenis_kelamin,
//	            @RequestParam(value = "is_tidak berlaku", required = false) int is_wni )throws ParseException 
//	    {
//	    	
//	    KeluargaModel keluarga = keluargaDAO.selectKeluarga2(id_keluarga);
//	    String kode_kecamatan = keluarga.getKelurahannya().getKecamatannya().getKode_kecamatan();
//	    //String id_kota = Integer.toString(keluarga.getKotanya().getId());
//	    String nik = "31"+kode_kecamatan;
//	    	PendudukModel penduduk = new PendudukModel(0, nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat, keluarga, keluarga.getKelurahannya(), keluarga.getKecamatannya(), keluarga.getKotanya());
//	    	model.addAttribute("penduduk", penduduk);
//	    	pendudukDAO.addPenduduk(penduduk);
//	    return "success-add-keluarga";
//	    }
}
