package com.xsis.bootcamp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.PersonelService;


@Controller
public class PersonelController extends BaseController{
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PersonelService personelService;
	
	
	@RequestMapping("/personel")
	public String getPersonelList(Model model){
		try {
			model.addAttribute("personel",personelService.listAll());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return "Personel";
	}
	
	@RequestMapping("/get-personel")
	public String getPersonel(Model model){
		try {
			Personel personel = getUser();
			model.addAttribute("success",true);
			model.addAttribute("personel",personel);
		} catch (Exception e) {
			model.addAttribute("success",false);
		}
		return null;
	}
	
	@RequestMapping("/new-personel")
	public String newPersonel(){
		return "list-new-user";
	}
	
	@RequestMapping("/savePersonel")
	public String savePersonel(Model model, @ModelAttribute Personel personel) {
		try {
			personelService.insert(personel);	
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		return null;
	}
	@RequestMapping("/updatePersonel")
		public String updatePersonel(Model model, @ModelAttribute Personel personel) {
			try {
				personelService.update(personel);
				model.addAttribute("success", true);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				model.addAttribute("success", false);
			}
			return null;
		}
	@RequestMapping("/deletePersonel")
	public String deletePersonel(Model model, @ModelAttribute Personel personel) {
		try {
			personelService.delete(personel);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		return null;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model, HttpServletRequest req) {
		String oldPass = req.getParameter("oldPass");
		String newPass = req.getParameter("newPass");
		//String oldPassword = req.getParameter("oldPassword");
		try {
			Personel personel = getUser();
			if(personel.getPassword().equalsIgnoreCase(oldPass)){
				personel.setPassword(newPass);
				personelService.update(personel);
				model.addAttribute("success", true);
			}else{
				model.addAttribute("success", false);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		return null;
	}
	
	@RequestMapping("/formChangePassword")
	public String formChangePassword() {
		
		return "user/changePassword";
	}
	
	@RequestMapping("/user-register")
	public String userRestRegister(Model model, HttpServletRequest request) {
		String pUsername = request.getParameter("username");
		String pPassword = request.getParameter("password");
		try {
			Personel p = personelService.getByUserName(pUsername);
			//username ada
			if(p!=null){
				model.addAttribute("message", "Username "+ pUsername +" telah dimiliki");
				model.addAttribute("success", false);
			}else{
				Personel personel = new Personel();
				personel.setUsername(pUsername);
				personel.setPassword(pPassword);
				//personel.setCreatedOn(new Date());
				personelService.insert(personel);
				model.addAttribute("message", "Berhasil Melakukan Registrasi");
				model.addAttribute("success", true);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("message", "Gagal Melakukan Registrasi");
			model.addAttribute("success", false);
		}
		return null;
	}

}
