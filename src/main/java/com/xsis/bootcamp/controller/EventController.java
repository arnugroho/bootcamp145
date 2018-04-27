package com.xsis.bootcamp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController {

	@Autowired
	EventService eventService;

	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

	@RequestMapping("/tabel")
	public void event(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("id") != null) {
			try {
				Event event = new Event();
				event = eventService.getEvent(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
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
				request.setAttribute("status", event.getStatus());
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
	}

	@RequestMapping("/form-insert")
	public String index() {
		return "event/form-event";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			Event event = new Event();
			String code = request.getParameter("code");
			String eventName = request.getParameter("eventName");
			String place = request.getParameter("place");
			Date endDate = sdf.parse(request.getParameter("endDate"));
			Long budget = Long.parseLong(request.getParameter("budget"));
			Date requestDate = sdf.parse(request.getParameter("requestDate"));
			int requestBy =Integer.parseInt(request.getParameter("requestBy"));
			
			
			Personel user = getUser();
			Date currentDate = new Date();
			
			event.setCode(code);
			event.setEventname(eventName);
			event.setPlace(place);
			event.setStartDate(currentDate);
			event.setEndDate(endDate);
			event.setBudget(budget);
			event.setRequestBy(requestBy);
			event.setRequestDate(requestDate);
			
			
			model.addAttribute("success", true);
		} catch (Exception e) {
			model.addAttribute("success", false);
		}
	}

	public void defaultList(HttpServletRequest request) {
		Collection<Event> eventCollection = new ArrayList<Event>();
		try {
			eventCollection = eventService.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("eventCollection", eventCollection);
	}

}
