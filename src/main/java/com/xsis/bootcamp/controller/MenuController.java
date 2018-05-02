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
			String controller = req.getParameter("cotroller");
			//bisa memanggil getUser() karena extend BaseController
			//fungsi getUser() ada di BaseController
			Personel user = getUser();
			Date currentDate = new Date();
			
			Menu menu = new Menu();
			menu.setName(name);
			menu.setController(controller);
			menu.setCreatedBy(user.getUsername());
			menu.setCreatedDate(currentDate);
			menu.setIsDelete(0);
			menuService.insert(menu);
			
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
				v.setName(menu.getName());
				v.setController(menu.getController());
				v.setId(menu.getId());
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
			String idMenuReq = req.getParameter("idMenu");
			String idMenu = idMenuReq;
			Menu menu = menuService.getByCode(idMenu);
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
	

}
