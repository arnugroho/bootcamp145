package com.xsis.bootcamp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.EventService;
import com.xsis.bootcamp.viewmodel.ViewEvent;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController {
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	EventService eventService;

	@RequestMapping("/form-event")
	public String index() {
		return "event/form-event";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest req) {
		try {
/*
			String code = req.getParameter("code");
			String eventName = req.getParameter("eventName");
			String place = req.getParameter("place");
			Date startDate = sdf.parse(req.getParameter("startDate"));
			Date endDate = sdf.parse(req.getParameter("endDate"));
			Long budget = Long.parseLong(req.getParameter("budget"));
			String note = req.getParameter("note");
*/
			Event event = new Event();
			event.setCode(req.getParameter("code"));
			event.setEventname(req.getParameter("eventName"));
			event.setPlace(req.getParameter("place"));
			event.setStartDate(sdf.parse(req.getParameter("startDate")));
			event.setEndDate(sdf.parse(req.getParameter("endDate")));
			event.setBudget(Long.parseLong(req.getParameter("budget")));
			event.setNote(req.getParameter("note"));

			Personel user = getUser();
			Date currentDate = new Date();

			event.setCreatedBy(user.getUsername());
			event.setCreatedDate(currentDate);
			event.setRequestBy(user.getId());
			event.setRequestDate(currentDate);
			event.setIsDelete(0);
			eventService.insert(event);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}

	}

	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest req) {
		try {
			Collection<Event> listEvent = eventService.listAll();
			
			Collection<ViewEvent> listViewEvent = new ArrayList<>();
			for (Event event : listEvent) {
				ViewEvent v = new ViewEvent();
				v.setCode(event.getCode());
				v.setEventName(event.getEventname());
				v.setRequestBy(event.getRequestBy());
				v.setRequestDate(event.getRequestDate());
				v.setCloseDate(event.getCloseDate());
				v.setStatus(event.getStatusDesc().getStatus());
				v.setCreatedDate(event.getCreatedDate());
				v.setCreateBy(event.getCreatedBy());
				listViewEvent.add(v);
			}
			model.addAttribute("listEvent", listViewEvent);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
	}


}
