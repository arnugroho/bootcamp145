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
		return "/unit/unit";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Personel personel = getUser();
			Date currentDate = new Date();

			Unit unit = new Unit();
			unit.setCode(code);
			unit.setName(name);
			unit.setCreatedDate(currentDate);
			unit.setCreatedBy(personel.getUsername());
			unit.setDescription(description);
			unit.setIsDelete(0);
			unitService.insert(unit);

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
			/* Date currentDate = new Date(); */
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
			// TODO: handle exception
		}
	}

}
