package com.example.tugas1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
import com.example.tugas1.service.PendudukService;

@Controller
public class PendudukController {
	@Autowired
    PendudukService pendudukDAO;
	
	@Autowired
	KeluargaService keluargaDAO;
	
	//index
    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }
    
    //fitur 1
    @RequestMapping("/penduduk")
    public String viewPath (Model model,
            @RequestParam(value = "nik", required = true) String nik)
    {
        PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);

        if (penduduk != null) {
            model.addAttribute ("penduduk", penduduk);
            System.out.println(penduduk);
            return "view-penduduk";
        } else {
//            model.addAttribute ("nik", nik);
            return "not-found-penduduk";
        }
    }
    
    
    @RequestMapping("/penduduk/tambah")
    public String add()
    {
    		return "form-tambah-penduduk";
    }
    
    @RequestMapping(value="/penduduk/tambah/submit", method=RequestMethod.POST)
    public String addSubmit (Model model,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
            @RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
            @RequestParam(value = "jenis_kelamin", required = false) int jenis_kelamin,
            @RequestParam(value = "is_wni", required = false) int is_wni,
            @RequestParam(value = "id_keluarga", required = false) int id_keluarga,
            @RequestParam(value = "perkerjaan", required = false) String pekerjaan,
            @RequestParam(value = "agama", required = false) String agama,
            @RequestParam(value = "status_perkawinan", required = false) String status_perkawinan,
            @RequestParam(value = "golongan_darah", required = false) String golongan_darah,
            @RequestParam(value = "is_wafat", required = false) int is_wafat,
            @RequestParam(value = "status_dalam_keluarga", required = false) String status_dalam_keluarga) throws ParseException 
    {
    	
    KeluargaModel keluarga = keluargaDAO.selectKeluarga2(id_keluarga);
    String nomor_kk = keluarga.getNomor_kk();
    KeluargaModel keluarga2 = keluargaDAO.selectKeluarga(nomor_kk);
    String kode_kecamatan = keluarga2.getKelurahannya().getKecamatannya().getKode_kecamatan();
    //String id_kota = Integer.toString(keluarga.getKotanya().getId());
    String nik = "31"+kode_kecamatan;
    	PendudukModel penduduk = new PendudukModel(0, nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat, keluarga, keluarga.getKelurahannya(), keluarga.getKecamatannya(), keluarga.getKotanya());
    	model.addAttribute("penduduk", penduduk);
    	pendudukDAO.addPenduduk(penduduk);
    return "success-add";
    }
    
    //soal 5 update penduduk
    @RequestMapping("/penduduk/ubah/{NIK}")
    public String update (Model model, @PathVariable(value = "NIK") String nik)
    {
    	 PendudukModel penduduk = pendudukDAO.selectPenduduk (nik);

         if (penduduk != null) {
             model.addAttribute ("penduduk", penduduk);
             return "form-update";
         } else {
             
             return "not-found";
         }
    	
    }
    
//    @RequestMapping(value = "/penduduk/ubah/submit", method = RequestMethod.POST)
//   public String updateSubmit(PendudukModel penduduk)
//    		{
//    			pendudukDAO.updatePenduduk(penduduk);
//    			return "success-update";
//    		}
    
    //fitur 7
    @RequestMapping(value = "/penduduk/mati/{nik}")
    public String updateKematian(Model model, @PathVariable(value = "nik", required = false) String nik) {
     PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
     penduduk.setIs_wafat(1);
     pendudukDAO.updatePendudukWafat(nik);
     model.addAttribute("penduduk", penduduk);
     return "sukses-update-kematian";
    }
}
