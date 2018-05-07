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

import com.xsis.bootcamp.model.Buku;
import com.xsis.bootcamp.model.Employee;
import com.xsis.bootcamp.model.Event;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.EventService;
import com.xsis.bootcamp.util.GeneralVariable;
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
			Event event = new Event();
			Employee employee = new Employee();
			employee.setId(1);
			event.setCode("");
			event.setEventname(req.getParameter("eventName"));
			event.setPlace(req.getParameter("place"));
			event.setStartDate(sdf.parse(req.getParameter("startDate")));
			event.setEndDate(sdf.parse(req.getParameter("endDate")));
			event.setBudget(Long.parseLong(req.getParameter("budget")));
			event.setNote(req.getParameter("note"));
			// event.setRequestByDesc(employee);

			Personel user = getUser();
			Date currentDate = new Date();

			event.setCreatedBy(user.getUsername());
			event.setCreatedDate(currentDate);
			event.setRequestBy(user.getId());
			event.setRequestDate(currentDate);
			event.setStatus(1);
			event.setIsDelete(0);
			eventService.insert(event);

			StringBuilder code = new StringBuilder();
			code.append(GeneralVariable.CODE_EVENT);
			String idEvent = String.valueOf(event.getId());
			if (idEvent.length() < 2) {
				idEvent = "000" + idEvent;
			} else if (idEvent.length() < 3) {
				idEvent = "00" + idEvent;
			} else if (idEvent.length() < 4) {
				idEvent = "0" + idEvent;
			}
			code.append(idEvent);
			event.setCode(code.toString());
			eventService.update(event);

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
				v.setEndDate(event.getEndDate());
				v.setStatus(event.getStatusDesc().getStatus());
				v.setCreatedDate(event.getCreatedDate());
				v.setCreateBy(event.getCreatedBy());
				v.setIdEvent(event.getId());
				listViewEvent.add(v);
			}
			model.addAttribute("listEvent", listViewEvent);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}

	}

	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest req) {
		try {
			String idEventReq = req.getParameter("idEvent");
			int idEvent = Integer.parseInt(idEventReq);
			Event event = eventService.get(idEvent);
			// set is deletenya 1, artinya delete
			event.setIsDelete(GeneralVariable.ISDELETE_TRUE);

			// update bukunya
			eventService.update(event);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}

	}

	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest req) {
		try {
			/**/
			String idEventReq = req.getParameter("idEvent");
			int idEvent = Integer.parseInt(idEventReq);
			Event event = eventService.get(idEvent);

			model.addAttribute("event", event);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/update")
	public void update(Model model, HttpServletRequest req) {
		try {
			Personel user = getUser();
			Date currentDate = new Date();
			String idReq = req.getParameter("id");
			int idEvent = Integer.parseInt(idReq);
			Event event = eventService.get(idEvent);

			event.setCode(req.getParameter("code"));
			event.setEventname(req.getParameter("eventName"));
			event.setPlace(req.getParameter("place"));
			event.setStartDate(sdf.parse(req.getParameter("startDate")));
			event.setEndDate(sdf.parse(req.getParameter("endDate")));
			event.setBudget(Long.parseLong(req.getParameter("budget")));
			event.setNote(req.getParameter("note"));
			event.setUpdatedBy(user.getUsername());
			event.setRequestDate(currentDate);
			eventService.update(event);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/prepare-form")
	public void prepareForm(Model model) {
		Personel user = getUser();
		model.addAttribute("requestBy", user.getUsername());

	}

}
