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

import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.MroleService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewRole;

@Controller
@RequestMapping("/role")
public class MroleController extends BaseController {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MroleService mroleService;

	@RequestMapping("/role")
	public String index() {
		return "role/role";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Personel personel = getUser();
			Date currentDate = new Date();

			Mrole mrole = new Mrole();
			mrole.setCode(code);
			mrole.setName(name);
			mrole.setDescription(description);
			mrole.setCreatedBy(personel.getUsername());
			mrole.setCreatedDate(currentDate);
			mrole.setIsDelete(0);
			mroleService.insert(mrole);

			model.addAttribute("success", true);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest request) {
		try {
			Collection<Mrole> listRole = mroleService.listAll();
			Collection<ViewRole> listViewRole = new ArrayList<>();
			for (Mrole mrole : listRole) {
				ViewRole v = new ViewRole();
				v.setCode(mrole.getCode());
				v.setName(mrole.getName());
				v.setCreatedDate(mrole.getCreatedDate());
				v.setCreatedBy(mrole.getCreatedBy());
				v.setIdRole(mrole.getId());
				listViewRole.add(v);
			}
			model.addAttribute("listRole", listViewRole);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest request) {
		try {
			String idRoleReq = request.getParameter("idRole");
			Long idRole = Long.parseLong(idRoleReq);
			Mrole mrole = mroleService.get(idRole);
			mrole.setIsDelete(GeneralVariable.ISDELETE_TRUE);

			mroleService.update(mrole);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest request) {
		try {
			String idRoleReq = request.getParameter("idRole");
			Long idRole = Long.parseLong(idRoleReq);
			Mrole mrole = mroleService.get(idRole);

			model.addAttribute("mrole", mrole);
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
			Long idRole = Long.parseLong(idReq);

			Mrole mrole = mroleService.get(idRole);
			mrole.setCode(code);
			mrole.setName(name);
			mrole.setDescription(description);
			mrole.setUpdatedBy(user.getUsername());
			mrole.setUpdatedDate(currentDate);
			mroleService.update(mrole);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
}
