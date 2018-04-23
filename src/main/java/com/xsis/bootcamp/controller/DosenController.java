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

import com.xsis.bootcamp.model.Dosen;
import com.xsis.bootcamp.model.Fakultas;
import com.xsis.bootcamp.model.Jurusan;
import com.xsis.bootcamp.model.Matkul;
import com.xsis.bootcamp.service.DosenService;
import com.xsis.bootcamp.service.FakultasService;
import com.xsis.bootcamp.service.JurusanService;
import com.xsis.bootcamp.service.MatkulService;

@Controller
public class DosenController {

	@Autowired
	DosenService dosenService;
	@Autowired
	FakultasService fakultasService;
	@Autowired
	JurusanService jurusanService;
	@Autowired
	MatkulService matkulService;
	
	@RequestMapping(value = {"/", "dosen-update.html"}, method = RequestMethod.GET)
	public String dosen(Model model, HttpServletRequest request) {
		
		request.setAttribute("action", "insert");
		if (request.getParameter("nikDosen") != null) {
			try {
				Dosen dosen = new Dosen();
				dosen = dosenService.getDosen(Integer.parseInt(request.getParameter("nikDosen")));
				request.setAttribute("nikDosen",Integer.parseInt(request.getParameter("nikDosen")));
				request.setAttribute("namaDosen", dosen.getNamaDosen());
				request.setAttribute("alamat", dosen.getAlamat());
				request.setAttribute("fakultas", dosen.getFakultas());
				request.setAttribute("jurusan", dosen.getJurusan());
				request.setAttribute("matkul", dosen.getMatkul());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", request.getParameter("action"));
		} else {
			request.setAttribute("action", "insert");
		}
		return "dosen";
	}
	
	@RequestMapping(value = {"/dosen-update.html","/dosen-insert"}, method = RequestMethod.POST)
	public String insert(Model model, HttpServletRequest request) {
		String action =request.getParameter("action");
		if (action.equalsIgnoreCase("insert")) {
			try {
				Dosen dosen = new Dosen();
				dosen.setNamaDosen(request.getParameter("namaDosen"));
				dosen.setAlamat(request.getParameter("alamat"));
				dosen.setFakultas(Integer.parseInt(request.getParameter("fakultas")));
				dosen.setJurusan(Integer.parseInt(request.getParameter("jurusan")));
				dosen.setMatkul(Integer.parseInt(request.getParameter("matkul")));
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
			}
			request.setAttribute("action", "insert");
		}
		return "dosen";
	}
	
	public void defaultList(HttpServletRequest request) {
		
		Collection<Dosen> dosenCollection = new ArrayList<Dosen>();
		Collection<Fakultas> fakultasCollection = new ArrayList<Fakultas>();
		Collection<Jurusan> jurusanCollection = new ArrayList<Jurusan>();
		Collection<Matkul> matkulCollection = new ArrayList<Matkul>();
		
		try {
			dosenCollection = dosenService.listDosen();
			fakultasCollection = fakultasService.listFakultas();
			jurusanCollection = jurusanService.listJurusan();
			matkulCollection = matkulService.listMatkul();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
		}
		
		request.setAttribute("dosenCollection", dosenCollection);
		request.setAttribute("fakultasCollection", fakultasCollection);
		request.setAttribute("jurusanCollection", jurusanCollection);
		request.setAttribute("matkulCollection", matkulCollection);
	}
	
}
