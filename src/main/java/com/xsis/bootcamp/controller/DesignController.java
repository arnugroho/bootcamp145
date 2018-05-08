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
import com.xsis.bootcamp.model.Design;
import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.DesignService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewDesign;

@Controller
@RequestMapping("/design")
public class DesignController extends BaseController {

	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DesignService designService;

	@RequestMapping("/form-design")
	public String index() {
		return "design/form-design";
	}

	@RequestMapping("/update")
	public void update(Model model, HttpServletRequest req) {
		try {
			Personel user = getUser();
			Date currentDate = new Date();
			
			String idReq = req.getParameter("id");
			String code = req.getParameter("code");
//			String tEventId = req.getParameter("eventCode");
			String titleHeader = req.getParameter("titleHeader");
//			String createdBy = req.getParameter("requestBy");
//			String createdDate = req.getParameter("requestDate");
			String note = req.getParameter("note");
			Integer idDesign = Integer.parseInt(idReq);

			Design design = designService.get(idDesign);
			design.setCode(code);
			design.setTitleHeader(titleHeader);
			design.setNote(note);
			design.setUpdatedBy(user.getUsername());
			design.setUpdatedDate(currentDate);
			designService.update(design);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest req) {
		try {
			String titleHeader = req.getParameter("titleHeader");
			String note = req.getParameter("note");

			Personel personel = getUser();
			Date currentDate = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
			String formatDate = sdf.format(currentDate);

			Design design = new Design();
			design.setCode("");
			design.settEventId(1);
			design.setTitleHeader(titleHeader);
			design.setCreatedBy(personel.getUsername());
			design.setCreatedDate(currentDate);
			design.setNote(note);
			design.setIsDelete(0);
			design.setStatus(1);
			designService.insert(design);

			StringBuilder codeDesign = new StringBuilder();
			codeDesign.append(GeneralVariable.KODE_DESIGN);
			String idDesign = String.valueOf(design.getId());
			if (idDesign.length() < 2) {
				idDesign = formatDate + "0000" + idDesign;
			} else if (idDesign.length() < 3) {
				idDesign = formatDate + "000" + idDesign;
			} else if (idDesign.length() < 4) {
				idDesign = formatDate + "00" + idDesign;
			} else if (idDesign.length() < 5) {
				idDesign = formatDate + "0" + idDesign;
			}

			codeDesign.append(idDesign);
			design.setCode(codeDesign.toString());
			designService.update(design);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}

	}

	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest request) {
		try {
			Collection<Design> listDesign = designService.listAll();

			Collection<ViewDesign> listViewDesign = new ArrayList<>();
			for (Design design : listDesign) {
				ViewDesign vd = new ViewDesign();
				vd.setCode(design.getCode());
				// vd.setRequestBy(design.getRequestByDesc().getFirstName());
				vd.setRequestDate(design.getRequestDate());
				vd.setAssignTo(design.getAssignTo());
				vd.setStatus(design.getStatusDesc().getStatus());
				vd.setCreatedDate(design.getCreatedDate());
				vd.setCreatedBy(design.getCreatedBy());
				
				vd.setIdDesign(design.getId());

				listViewDesign.add(vd);
			}

			model.addAttribute("listDesign", listViewDesign);
			model.addAttribute("success", true);

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest req) {
		try {
			String idDesignReq = req.getParameter("idDesign");
			Integer idDesign = Integer.parseInt(idDesignReq);
			Design design = designService.get(idDesign);
			
			model.addAttribute("design", design);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	
}
