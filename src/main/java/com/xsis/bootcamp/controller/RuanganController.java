package com.xsis.bootcamp.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xsis.bootcamp.model.Ruangan;
import com.xsis.bootcamp.service.RuanganService;

@Controller
public class RuanganController {
	@Autowired
	RuanganService ruanganService;
	
	
	 @RequestMapping(value = { "/", "/ruangan.html", "/ruangan-update.html" }, method = RequestMethod.GET)
	public String ruangan(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("idruangan") != null) {
			try {
				Ruangan ruangan = new Ruangan();
				ruangan = ruanganService.getRuangan(Integer.parseInt(request.getParameter("idruangan")));
				request.setAttribute("idruangan",Integer.parseInt(request.getParameter("idruangan")));
				request.setAttribute("namaruangan", ruangan.getNamaRuangan());
//				request.setAttribute("Ruangan", ruangan);
							
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			request.setAttribute("action", request.getParameter("action"));
		} else {
			request.setAttribute("action", "insert");
		}
		defaultList(request);
		return "ruangan-list";
	}

	
	public void defaultList(HttpServletRequest request) {
		Collection<Ruangan> ruanganCollection =new ArrayList<Ruangan>();
		try {
			ruanganCollection = ruanganService.listRuangan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
	request.setAttribute("ruanganCollection", ruanganCollection);
	}
}
