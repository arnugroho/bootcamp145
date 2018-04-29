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
import com.xsis.bootcamp.service.MroleService;

@Controller
@RequestMapping("/role")
public class MroleController  {

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
		return "role/role";
	}

	@RequestMapping(value="/role-insert")
	public void registrasiRole(Model model, HttpServletRequest request) {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		if((name !=null) && (!name.equals(""))) {
			try {
				Mrole checkName = mroleService.getRole(0);
				if(checkName==null) {
					Mrole mrole = new Mrole();
					mrole.setName(name);
					mrole.setCode(code);
					mrole.setDescription(description);
					mrole.setCreatedBy(name);
					mrole.setCreatedDate(new Date());
					mrole.setIsDelete(0);
					mrole.setUpdatedBy(name);
					mrole.setUpdatedDate(new Date());
					mroleService.insert(mrole);
					
					model.addAttribute("message","Registrasi Role Berhasil");
					model.addAttribute("success", true);
				} else{
					model.addAttribute("message","Role Name sudah ada");
					model.addAttribute("success", false);
				}
			} catch (Exception e) {
				model.addAttribute("message", e.getMessage());
				model.addAttribute("success", false);
			}
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
