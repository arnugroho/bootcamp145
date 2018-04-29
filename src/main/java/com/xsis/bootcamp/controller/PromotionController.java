package com.xsis.bootcamp.controller;


//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Promotion;
import com.xsis.bootcamp.service.PromotionService;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	PromotionService promotionService;
	
	//private SimpleDateFormat sdf = new SimpleDateFormat("YYY-MM-DD");
	
	@RequestMapping(value = {"/promotion"})
	public String promotion(Model model, HttpServletRequest request) {
		
		request.setAttribute("action", "insert");
		if (request.getParameter("code")!= null) {
			try {
				Promotion promotion = new Promotion();
				promotion = promotionService.getById(request.getParameter("id"));
				request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
				request.setAttribute("code", promotion.getCode());
				request.setAttribute("flagDesign", promotion.getFlagDesign());
				request.setAttribute("requestDate", promotion.getRequestDate());
				request.setAttribute("approvedDate", promotion.getApprovedDate());
				request.setAttribute("closedDate", promotion.getCloseDate());
				request.setAttribute("note", promotion.getNote());
				request.setAttribute("status", promotion.getStatus());
				request.setAttribute("rejectReason", promotion.getRejectReason());
				request.setAttribute("flagDesign", promotion.getFlagDesign());
				request.setAttribute("createdDate", promotion.getCreatedDate());
				request.setAttribute("createdBy", promotion.getCreatedBy());
				request.setAttribute("updatedDate", promotion.getUpdatedDate());
				request.setAttribute("updatedBy", promotion.getUpdatedBy());
				request.setAttribute("tEventId", promotion.gettEventId());
				request.setAttribute("tDesignId", promotion.gettDesignId());
				request.setAttribute("requestBy", promotion.getRequestBy());
				request.setAttribute("approvedBy", promotion.getApprovedBy());
				request.setAttribute("assignTo", promotion.getAssignTo());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMesssage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		} else {
			request.setAttribute("action", "insert");
		}
		defaultList(request);
		return "promotion/promotion";
	}
	
	

	public void defaultList(HttpServletRequest request) {
		
		Collection<Promotion> promotionCollection = new ArrayList<Promotion>();
		try {
			promotionCollection = promotionService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		
		request.setAttribute("promotionCollection", promotionCollection);
		
	}
	
}

