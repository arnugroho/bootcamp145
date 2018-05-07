package com.xsis.bootcamp.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.BukuService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewBuku;

@Controller
@RequestMapping("/buku")
public class BukuController extends BaseController{
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private BukuService bukuService;
	
	@RequestMapping("/form")
	public String index() {
		return "buku/form";
	}
	
	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest req) {
		try {
			String namaBuku =  req.getParameter("namaBuku");
			String pengarang = req.getParameter("pengarang");
			//bisa memanggil getUser() karena extend BaseController
			//fungsi getUser() ada di BaseController
			Personel user = getUser();
			Date currentDate = new Date();
			
			Buku buku = new Buku();
			buku.setNamaBuku(namaBuku);
			buku.setPengarang(pengarang);
			buku.setCreatedBy(user.getUsername());
			buku.setCreatedDate(currentDate);
			buku.setIsDelete(0);
			bukuService.insert(buku);
			StringBuilder kodeBuku = new StringBuilder();
			kodeBuku.append(GeneralVariable.KODE_BUKU);
			String idBuku = String.valueOf(buku.getId());
			if(idBuku.length() < 2) {
				idBuku = "000"+idBuku;
			}else if(idBuku.length() < 3) {
				idBuku = "00"+idBuku;
			}else if(idBuku.length() < 4) {
				idBuku = "0"+idBuku;
			}
			kodeBuku.append(idBuku);
			
			buku.setKodeBuku(kodeBuku.toString());
			bukuService.update(buku);
			
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	
	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest req) {
		try {
			Collection<Buku> listBuku = bukuService.listAll();
			
			//view buku meruapakan bean object untuk memudahkan komunikasi data.
			// jadi memang data yang dilempar kedepan adalah data yang dibutuhkan untuk ditampilkan
			Collection<ViewBuku> listViewBuku = new ArrayList<>();
			for (Buku buku : listBuku) {
				ViewBuku v = new ViewBuku();
				v.setNamaBuku(buku.getNamaBuku());
				v.setPengarang(buku.getPengarang());
				v.setIdBuku(buku.getId());
				listViewBuku.add(v);
			}
			model.addAttribute("listBuku", listViewBuku);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	
	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest req) {
		try {
			String idBukuReq = req.getParameter("idBuku");
			Long idBuku = Long.parseLong(idBukuReq);
			Buku buku = bukuService.get(idBuku);
			//set is deletenya 1, artinya delete
			buku.setIsDelete(GeneralVariable.ISDELETE_TRUE);
			
			//update bukunya
			bukuService.update(buku);
			
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	
	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest req) {
		try {
			String idBukuReq = req.getParameter("idBuku");
			Long idBuku = Long.parseLong(idBukuReq);
			Buku buku = bukuService.get(idBuku);
			
			model.addAttribute("buku", buku);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/update")
	public void update(Model model, HttpServletRequest req) {
		try {
			Personel user = getUser();
			Date currentDate = new Date();
			String idReq = req.getParameter("id");
			String namaBuku = req.getParameter("namaBuku");
			String pengarang = req.getParameter("pengarang");
			Long idBuku = Long.parseLong(idReq);
			
			Buku buku = bukuService.get(idBuku);
			buku.setNamaBuku(namaBuku);
			buku.setPengarang(pengarang);
			buku.setUpdatedBy(user.getUsername());
			buku.setUpdatedDate(currentDate);
			bukuService.update(buku);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/prepare-form")
	public void prepareForm(Model model) {
		Personel user = getUser();
		
		model.addAttribute("requestBy", user.getUsername());
		
	}
	

}
