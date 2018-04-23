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

import com.xsis.bootcamp.model.Jurusan;
import com.xsis.bootcamp.service.JurusanService;

@Controller
public class JurusanController {
	
	@Autowired
	JurusanService jurusanService;
	
	@RequestMapping(value = "/fakultas.html", method = RequestMethod.POST)
	public String jurusan(Model model, HttpServletRequest request) {
		request.setAttribute("action", "insert");
		if (request.getParameter("idJurusan") != null) {
			try {
				Jurusan jurusan = new Jurusan();
				jurusan = jurusanService.getJurusan(Integer.parseInt(request.getParameter("idJurusan")));
				request.setAttribute("idJurusan", Integer.parseInt(request.getParameter("idJurusan")));
				request.setAttribute("namaJurusan", jurusan.getNamaJurusan());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("action", "insert");
			}

		}
		jurusanList(request);
		return "jurusan";
	}

	private void jurusanList(HttpServletRequest request) {
		Collection<Jurusan> jurusanCollection = new ArrayList<Jurusan>();
		try {
			jurusanCollection = jurusanService.listJurusan();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		request.setAttribute("jurusanCollection", jurusanCollection);
	}
}
