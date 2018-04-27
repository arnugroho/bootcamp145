package com.xsis.bootcamp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.MroleService;

@Controller

public class MroleController extends BaseController {

	@Autowired
	MroleService mroleService;

	@RequestMapping(value = { "/role" })
	public String role(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("id") != null) {
			try {
				Mrole mrole = new Mrole();
				mrole = mroleService.getRole(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("code", mrole.getCode());
				request.setAttribute("name", mrole.getName());
				request.setAttribute("created_date", mrole.getCreatedDate());
				request.setAttribute("created_by", mrole.getCreatedBy());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		}
		defaultList(request);
		return "mrole";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Personel user = getUser();
			Date currentDate = new Date();

			Mrole mrole = new Mrole();
			mrole.setCode(code);
			mrole.setName(name);
			mrole.setDescription(description);
			mrole.setCreatedBy(user.getUsername());
			mrole.setCreatedDate(currentDate);
			mrole.setIsDelete(0);
			mroleService.insert(mrole);

			model.addAttribute("success", true);
		} catch (Exception e) {
			model.addAttribute("success", false);
		}
	}

	public void defaultList(HttpServletRequest request) {
		Collection<Mrole> mroleCollection = new ArrayList<Mrole>();
		try {
			mroleCollection = mroleService.listAll();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("mroleCollection", mroleCollection);
	}

}
