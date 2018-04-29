package com.xsis.bootcamp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xsis.bootcamp.model.Design;
import com.xsis.bootcamp.service.DesignService;

@Controller
public class DesignController {
	@Autowired
	DesignService designService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

	@RequestMapping(value= {"/design/form-design.html"})
	public String Design(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("code") != null) {
			try {
				Design design = new Design();
				design = designService.getByCode(request.getParameter("code"));
				request.setAttribute("id", design.getId());
				request.setAttribute("code", request.getParameter("code"));
				request.setAttribute("titleHeader", design.getTitleHeader());
				request.setAttribute("requestDate", design.getRequestDate());
				request.setAttribute("approveDate", design.getApprovedDate());
				request.setAttribute("closeDate", design.getClosedDate());
				request.setAttribute("note", design.getNote());
				request.setAttribute("status", design.getStatus());
				request.setAttribute("rejectReason", design.getRejectReason());
				request.setAttribute("createdDate", design.getCreatedDate());
				request.setAttribute("createBy", design.getCreatedBy());
				request.setAttribute("updatedDate", design.getUpdatedDate());
				request.setAttribute("updatedBy", design.getUpdatedBy());
				request.setAttribute("isDelete", design.getIsDelete());
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCause(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		} else {
			request.setAttribute("action", "insert");
		}
		defaultList(request);
		return "design/form-design";
		
	}
	
	public void defaultList (HttpServletRequest request) {
		Collection<Design> designCollection = new ArrayList<Design>();
		try {
			designCollection = designService.listAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCause(e));
		}
		request.setAttribute("designCollection", designCollection);
	}
}
