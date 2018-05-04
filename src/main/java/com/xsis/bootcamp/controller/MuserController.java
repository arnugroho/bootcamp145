package com.xsis.bootcamp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.Mrole;
import com.xsis.bootcamp.model.Muser;
import com.xsis.bootcamp.service.MuserService;

@Controller
@RequestMapping("/member")
public class MuserController extends BaseController {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	MuserService muserService;

	@RequestMapping("/member")
	public String index() {
		return "member/member";
	}
	
	@RequestMapping("/insert")
	public void insert(Model model,HttpServletRequest request) {
		String pUsername = request.getParameter("usernmae");
		String pPassword = request.getParameter("password");
		try {
			Muser m = muserService.getByUsername(pUsername);
			if (m!=null) {
				model.addAttribute("message","Username" + pUsername + "Telah di Miliki");
				model.addAttribute("success",false);
			} else {
				Muser muser = new Muser();
				Mrole mrole = new Mrole();
				Date currentDate = new Date();
				muser.setUsername(pUsername);
				muser.setPassword(pPassword);
				muser.setCreatedDate(currentDate);
				muser.setCreatedBy(mrole.getName());
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
