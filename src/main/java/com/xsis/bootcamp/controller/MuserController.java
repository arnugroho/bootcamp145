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

/*import com.xsis.bootcamp.model.Employee;*/
import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.model.Muser;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.MroleService;
import com.xsis.bootcamp.service.MuserService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewUser;

@Controller
@RequestMapping("/member")
public class MuserController extends BaseController {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	MuserService muserService;

	@Autowired
	MroleService mroleService;
	
	/*@Autowired
	RoleService roleService;*/

	@RequestMapping("/member")
	public String index() {
		return "member/member";
	}
	
	@RequestMapping("/insert")
	public void insert(Model model,HttpServletRequest request) {
		String pUsername = request.getParameter("username");
		String pPassword = request.getParameter("password");
		String mRoleId = request.getParameter("mRoleId");
		Integer RoleId = Integer.parseInt(mRoleId);
		try {
			Muser m = muserService.getByUsername(pUsername);
			if (m!=null) {
				model.addAttribute("message","Username" + pUsername + "Telah di Miliki");
				model.addAttribute("success",false);
			} else {
				Personel personel = getUser();
				Muser muser = new Muser();
				Date currentDate = new Date();
				muser.setUsername(pUsername);
				muser.setPassword(pPassword);
				muser.setmRoleId(RoleId);
				muser.setmEmployeeId(2);
				muser.setCreatedDate(currentDate);
				muser.setCreatedBy(personel.getUsername());
				muser.setIsDelete(0);
				muserService.insert(muser);
				
				model.addAttribute("message"," Berhasil Melakukan Registrasi");
				model.addAttribute("success", true);
				
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			model.addAttribute("message", "Gagal Melakukan Registrasi");
			model.addAttribute("success",false);
		}
	}
	
	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest request) {
		try {
			Collection<Muser> listUser = muserService.listAll();
			Collection<ViewUser> listViewUser = new ArrayList<>();
			for(Muser muser : listUser) {
				ViewUser v = new ViewUser();
				Mrole mrole = mroleService.get(muser.getmRoleId());
				/*Role role = roleService.get(muser.getmRoleId());*/
				
				/*v.setNameRole(role.getRoleName());*/
				v.setNameRole(mrole.getName());
				v.setUsername(muser.getUsername());
				v.setCreatedDate(muser.getCreatedDate());
				v.setCreatedBy(muser.getCreatedBy());
				v.setIdUser(muser.getId());
				listViewUser.add(v);
			}
			model.addAttribute("listUser", listViewUser);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			model.addAttribute("success",false);
		}
	}
	
	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest request) {
		try {
			String idUserReq = request.getParameter("idUser");
			Integer idUser = Integer.parseInt(idUserReq);
			Muser muser= muserService.get(idUser);
			muser.setIsDelete(GeneralVariable.ISDELETE_TRUE);
			
			muserService.update(muser);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest request) {
		try {
			String idUserReq = request.getParameter("idUser");
			Integer idUser = Integer.parseInt(idUserReq);
			Muser muser = muserService.get(idUser);
			

			model.addAttribute("muser", muser);
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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mRoleId = request.getParameter("mRoleId");
			Integer RoleId = Integer.parseInt(mRoleId);
			Integer idUser = Integer.parseInt(idReq);
			Muser muser = muserService.get(idUser);
			muser.setUsername(username);
			muser.setPassword(password);
			muser.setmRoleId(RoleId);
			muser.setUpdatedBy(user.getUsername());
			muser.setUpdatedDate(currentDate);
			muserService.update(muser);
			

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/getname")
	public void getName(Model model, HttpServletRequest request) {
		try {
//			Collection<Role> listRole = roleService.listAll();
			Collection<Mrole> listMrole = mroleService.listAll();
//			model.addAttribute("listRole", listRole);
			model.addAttribute("listMrole", listMrole);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			model.addAttribute("success", false);
			
		}
	}
}

/*
 * @RequestMapping(value= {"/member/member.html"}) public String user(Model
 * model, HttpServletRequest request) { request.setAttribute("action",
 * "insert"); if(request.getParameter("id")!=null) { try { Muser muser = new
 * Muser(); muser =
 * muserService.getUser(Integer.parseInt(request.getParameter("id")));
 * request.setAttribute("employee_id", muser.getmEmployeeId()); //
 * request.setAttribute("company_id", muser.getmCompanyId());
 * request.setAttribute("username", muser.getUsername());
 * request.setAttribute("created_date", muser.getCreatedDate());
 * request.setAttribute("created_by", muser.getCreatedBy()); } catch (Exception
 * e) { e.printStackTrace(); request.setAttribute("errorMessage",
 * ExceptionUtils.getRootCauseMessage(e)); } request.setAttribute("action",
 * request.getParameter("action")); } defaultList(request); return
 * "member/member"; }
 * 
 * public void defaultList(HttpServletRequest request) { Collection<Muser>
 * muserCollection = new ArrayList<Muser>(); try { muserCollection =
 * muserService.listAll(); } catch (Exception e) { e.printStackTrace();
 * request.setAttribute("errorMessage", ExceptionUtils.getRootCauseMessage(e));
 * } request.setAttribute("muserCollection", muserCollection); }
 */
