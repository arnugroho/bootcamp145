package com.xsis.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buku")
public class BukuController {
	
	@RequestMapping("/form")
	public String index() {
		return "buku/form";
	}

}
