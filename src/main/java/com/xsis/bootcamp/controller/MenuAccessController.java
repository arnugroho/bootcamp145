package com.xsis.bootcamp.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.MenuAccess;
import com.xsis.bootcamp.service.MenuAccessService;

@Controller
public class MenuAccessController extends BaseController{
	
	@Autowired
	MenuAccessService menuAccessService;
	
	@RequestMapping(value= {"/menu-access/form.html"})
	public String menuAccess(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if(request.getParameter("id")!=null) {
			try {
				MenuAccess menuAccess = new MenuAccess();
				menuAccess = menuAccessService.getId(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("role_id", menuAccess.getmRoleId());
				request.setAttribute("menu_id", menuAccess.getmMenuId());
				request.setAttribute("created_date", menuAccess.getCreatedDate());
				request.setAttribute("created_by", menuAccess.getCreatedBy());				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		}
		defaultList(request);
		return "menu-access/modal";
	}
	
	public void defaultList(HttpServletRequest request) {
		Collection<MenuAccess> menuAccessCollection = new ArrayList<MenuAccess>();
		try {
			menuAccessCollection = menuAccessService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("menuAccessCollection", menuAccessCollection);
	}

}
