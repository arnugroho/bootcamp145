package com.xsis.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController extends BaseController{

	@RequestMapping(value={"", "/"})
	public String home(Model model) {
		/*String result = null;
		UserDetails userDetail = getUserDetail();
		for (GrantedAuthority a : userDetail.getAuthorities()) {
			if(a.getAuthority().equalsIgnoreCase(GeneralVariable.ROLE_MAHASISWA)){
				model.addAttribute("pId", getUser().getpId());
				result = "edom/data-matakuliah";
			} else if(a.getAuthority().equalsIgnoreCase(GeneralVariable.ROLE_ADMIN)) {
				result = "admin/dashboard/admin-dashboard";
			}
		}*/
		String result = "home";
		return result;
	}
	
	@RequestMapping(value={"ajaxNull"})
	public String ajaxNull(Model model) {
		
		return null;
	}

}
