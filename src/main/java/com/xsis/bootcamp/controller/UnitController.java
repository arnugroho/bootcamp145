package com.xsis.bootcamp.controller;

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

import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.model.Unit;
import com.xsis.bootcamp.service.UnitService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewUnit;

@Controller
@RequestMapping("/unit")
public class UnitController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private UnitService unitService;

	@RequestMapping("/unit")
	public String index() {
		return "unit/unit";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Personel personel = getUser();
			Date currentDate = new Date();
			Unit unit = new Unit();
			unit.setName(name);
			unit.setCreatedDate(currentDate);
			unit.setCreatedBy(personel.getUsername());
			unit.setDescription(description);
			unit.setIsDelete(0);
			unitService.insert(unit);
			StringBuilder codeUnit = new StringBuilder();
			codeUnit.append(GeneralVariable.KODE_UNIT);
			String idUnit = String.valueOf(unit.getId());
			if (idUnit.length() < 2) {
				idUnit = "000" + idUnit;
			} else if (idUnit.length() < 3) {
				idUnit = "00" + idUnit;
			} else if (idUnit.length() < 4) {
				idUnit = "0" + idUnit;
			}
			codeUnit.append(idUnit);
			
			unit.setCode(codeUnit.toString());
			unitService.update(unit);
			

			model.addAttribute("success", true);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest request) {
		try {
			Collection<Unit> listUnit = unitService.listAll();
			Collection<ViewUnit> listViewUnit = new ArrayList<>();
			for (Unit unit : listUnit) {
				ViewUnit v = new ViewUnit();
				v.setCode(unit.getCode());
				v.setName(unit.getName());
				v.setCreatedDate(unit.getCreatedDate());
				v.setCreatedBy(unit.getCreatedBy());
				v.setIdUnit(unit.getId());
				listViewUnit.add(v);
			}
			model.addAttribute("listUnit", listViewUnit);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest request) {
		try {
			String idUnitReq = request.getParameter("idUnit");
			Long idUnit = Long.parseLong(idUnitReq);
			Unit unit = unitService.get(idUnit);
			unit.setIsDelete(GeneralVariable.ISDELETE_TRUE);

			unitService.update(unit);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest request) {
		try {
			String idUnitReq = request.getParameter("idUnit");
			Long idUnit = Long.parseLong(idUnitReq);
			Unit unit = unitService.get(idUnit);

			model.addAttribute("unit", unit);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/update")
	public void update(Model model, HttpServletRequest request) {
		try {
			Personel user = getUser();
			Date currentDate = new Date();
			String idReq = request.getParameter("id");
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Long idUnit = Long.parseLong(idReq);

			Unit unit = unitService.get(idUnit);
			unit.setCode(code);
			unit.setName(name);
			unit.setDescription(description);
			unit.setUpdatedBy(user.getUsername());
			unit.setUpdatedDate(currentDate);
			unitService.update(unit);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
}
