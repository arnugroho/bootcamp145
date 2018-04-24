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

import com.xsis.bootcamp.model.Fakultas;
import com.xsis.bootcamp.service.FakultasService;

@Controller
public class FakultasController {
	@Autowired
	FakultasService fakultasService;

	@RequestMapping(value = { "/fakultas.html", "/fakultas-update.html" }, method = RequestMethod.POST)
	public String fakultas(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("idFakultas") != null) {
			try {
				Fakultas fakultas = new Fakultas();
				fakultas = fakultasService.getFakultas(Integer.parseInt(request.getParameter("idFakultas")));
				request.setAttribute("idFakultas", Integer.parseInt(request.getParameter("idFakultas")));
				request.setAttribute("namaFakultas", fakultas.getNamaFakultas());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("action", "insert");
			}

		}
		fakultasList(request);
		return "fakultas";
	}

	@RequestMapping(value = { "/fakultas-update.html", "/fakultas-insert" }, method = RequestMethod.POST)
	public String insert(Model model, HttpServletRequest request) {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("insert")) {
			try {
				Fakultas fakultas = new Fakultas();
				fakultas.setNamaFakultas(request.getParameter("namaFakultas"));
				fakultasService.insertFakultas(fakultas);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", "insert");

		}
		fakultasList(request);
		return "fakultas";

	}

	private void fakultasList(HttpServletRequest request) {
		Collection<Fakultas> fakultasCollection = new ArrayList<Fakultas>();
		try {
			fakultasCollection = fakultasService.listFakultas();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("fakultasCollection", fakultasCollection);
	}
}
