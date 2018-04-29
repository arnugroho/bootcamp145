package com.xsis.bootcamp.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Muser;
import com.xsis.bootcamp.service.MuserService;

@Controller
public class MuserController extends BaseController{
	
	@Autowired
	MuserService muserService;
	
	@RequestMapping(value= {"/member/user.html"})
	public String user(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if(request.getParameter("id")!=null) {
			try {
				Muser muser = new Muser();
				muser = muserService.getUser(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("employee_id", muser.getmEmployeeId());
				request.setAttribute("company_id", muser.getmCompanyId());
				request.setAttribute("username", muser.getUsername());
				request.setAttribute("created_date", muser.getCreatedDate());
				request.setAttribute("created_by", muser.getCreatedBy());				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		}
		defaultList(request);
		return "member/user";
	}
	
	public void defaultList(HttpServletRequest request) {
		Collection<Muser> muserCollection = new ArrayList<Muser>();
		try {
			muserCollection = muserService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("muserCollection", muserCollection);
	}

}
