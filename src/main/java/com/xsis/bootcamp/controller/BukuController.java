package com.xsis.bootcamp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.BukuService;
import com.xsis.bootcamp.util.GeneralVariable;

@Controller
@RequestMapping("/buku")
public class BukuController extends BaseController{
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
			model.addAttribute("success", false);
		}
		
		
		
	}
	

}
