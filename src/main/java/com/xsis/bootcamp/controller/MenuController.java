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

import com.xsis.bootcamp.model.Menu;
import com.xsis.bootcamp.model.Menu;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.MenuService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewMenu;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
	
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/form")
	public String index() {
		return "menu/form";
	}
	
	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest req) {
		try {
			String name =  req.getParameter("name");
			String controller = req.getParameter("controller");
			//bisa memanggil getUser() karena extend BaseController
			//fungsi getUser() ada di BaseController
			Personel user = getUser();
			Date currentDate = new Date();
			
			Menu menu = new Menu();
			menu.setCode("");
			menu.setName(name);
			menu.setController(controller);
			menu.setCreatedBy(user.getUsername());
			menu.setCreatedDate(currentDate);
			menu.setIsDelete(0);
			menu.setParentId(1);
			menuService.insert(menu);
			
			StringBuilder codeMenu = new StringBuilder();
			codeMenu.append(GeneralVariable.KODE_MENU);
			String idMenu = String.valueOf(menu.getId());
			if(idMenu.length()<2) {
				idMenu = "000" + idMenu;
			} else if(idMenu.length()<3) {
				idMenu ="00" + idMenu;
			} else if(idMenu.length()<4) {
				idMenu = "0" + idMenu;
			}
			
			codeMenu.append(idMenu);
			menu.setCode(codeMenu.toString());
			menuService.update(menu);
			
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
			Long idMenu = Long.parseLong(idReq);

			Menu menu = menuService.getById(idMenu);
			menu.setCode(code);
			menu.setName(name);
			menu.setUpdatedBy(user.getUsername());
			menu.setUpdatedDate(currentDate);
			menuService.update(menu);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest req) {
		try {
			Collection<Menu> listMenu = menuService.listAll();
			
			//view menu meruapakan bean object untuk memudahkan komunikasi data.
			// jadi memang data yang dilempar kedepan adalah data yang dibutuhkan untuk ditampilkan
			Collection<ViewMenu> listViewMenu = new ArrayList<>();
			for (Menu menu : listMenu) {
				ViewMenu v = new ViewMenu();
				v.setCode(menu.getCode());
				v.setName(menu.getName());
				v.setController(menu.getController());
				v.setCreatedBy(menu.getCreatedBy());
				v.setmId(menu.getId());
				listViewMenu.add(v);
			}
			model.addAttribute("listMenu", listViewMenu);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	
	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest req) {
		try {
			String mIdReq = req.getParameter("mId");
			Long mId = Long.parseLong(mIdReq);
			Menu menu = menuService.getById(mId);
			//set is deletenya 1, artinya delete
			menu.setIsDelete(GeneralVariable.ISDELETE_TRUE);
			
			//update menunya
			menuService.update(menu);
			
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
		
		
		
	}
	

	@RequestMapping("/prepare-form")
	public void prepareForm(Model model) {
		Personel user = getUser();
		model.addAttribute("createdBy", user.getUsername());

		
	}
	

}
