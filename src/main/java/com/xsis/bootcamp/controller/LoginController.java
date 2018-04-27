/**
 * 
 */
package com.xsis.bootcamp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.PersonelService;
import com.xsis.bootcamp.util.GeneralVariable;

/**
 * @author Awiyanto Ajisasongko
 *
 */
@Controller
public class LoginController {
	@Autowired
	PersonelService personelService;

	@RequestMapping(value = "/home")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "denied", required = false) String denied, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		if (denied != null) {
			model.addObject("msg", "Access Denied. Session Time Out");
		}

		model.setViewName("home");

		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;

	}

	@RequestMapping(value = "/registrasi-user")
	public String registrasiUser(HttpServletRequest req, Model model) {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		if ((username != null && pass != null) && (!username.equals("") && !pass.equals(""))) {
			try {
				Personel checkUsername = personelService.getByUserName(username);
				if (checkUsername == null) {
					Personel personel = new Personel();
					personel.setUsername(username);
					personel.setPassword(pass);
					personel.setUpdatedBy(username);
					personel.setUpdatedDate(new Date());
					personel.setRoleId(GeneralVariable.USER_ROLE_USERSD);
					personel.setUserCode(username);
					personel.setCreatedBy(username);
					personel.setCreatedDate(new Date());
					personel.setIsDelete(0);
					personel.setIsActive(1);
					personel.setEmail(email);
					personelService.insert(personel);

					model.addAttribute("message", "Registrasi user berhasil");
					model.addAttribute("success", true);
				} else {
					model.addAttribute("message", "Username sudah ada!");
					model.addAttribute("success", false);
				}
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				model.addAttribute("success", false);
			}
		} else {
			model.addAttribute("message", "Password dan username tidak boleh kosong");
			model.addAttribute("success", false);
		}
		return null;
	}
	/*
	 * @RequestMapping(value="/logout", method = RequestMethod.GET) public String
	 * logoutPage (HttpServletRequest request, HttpServletResponse response) {
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * if (auth != null){ new SecurityContextLogoutHandler().logout(request,
	 * response, auth); } return "home"; }
	 */
}
