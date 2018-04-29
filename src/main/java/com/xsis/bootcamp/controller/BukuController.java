package com.xsis.bootcamp.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.BukuService;
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
				listViewBuku.add(v);
			}
			model.addAttribute("listBuku", listViewBuku);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	

}
