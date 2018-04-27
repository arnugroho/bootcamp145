package com.xsis.bootcamp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.service.MuserService;

@Controller
public class MuserController extends BaseController{
	
	@Autowired
	MuserService muserService;
	
	@RequestMapping(value= {"/user"})
	public String user(Model model, HttpServletRequest request) {
		
		
		return "user";
	}

}
