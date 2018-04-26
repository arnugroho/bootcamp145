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
import org.springframework.web.bind.annotation.RequestMethod;

import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.service.EventService;

@Controller
public class EventController {
	
	 @Autowired
	 EventService eventService;
	 
	 private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	 @RequestMapping("/event")
	public String event(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("id") != null) {
			try {
				Event event = new Event();
				event = eventService.getEvent(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
				request.setAttribute("code", event.getCode());
				request.setAttribute("eventName", event.getEventname());
				request.setAttribute("startDate", event.getStartDate());
				request.setAttribute("endDate", event.getEndDate());
				request.setAttribute("place", event.getPlace());
				request.setAttribute("budget", event.getBudget());
				request.setAttribute("requestBy", event.getRequestBy());
				request.setAttribute("requestDate", event.getRequestDate());
				request.setAttribute("approveBy", event.getApprovedBy());
				request.setAttribute("approveDate", event.getApprovedDate());
				request.setAttribute("assignTo", event.getAssignTo());
				request.setAttribute("closeDate", event.getCloseDate());
				request.setAttribute("note", event.getNote());
				request.setAttribute("statuse", event.getStatus());
				request.setAttribute("rejectReason", event.getRejectReason());
				request.setAttribute("isDelete", event.getIsDelete());
				request.setAttribute("createdBy", event.getCreatedBy());
				request.setAttribute("createDate", event.getCreatedDate());
				request.setAttribute("updatedBy", event.getUpdatedBy());
				request.setAttribute("updatedDate", event.getUpdatedDate());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			request.setAttribute("action", request.getParameter("action"));
		} else {
			request.setAttribute("action", "insert");
		}
		defaultList(request);
		return "event";
	}

	
	public void defaultList(HttpServletRequest request) {
		Collection<Event> eventCollection =new ArrayList<Event>();
		try {
			eventCollection =eventService.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
	request.setAttribute("eventCollection", eventCollection);
	}
	 
	
}
