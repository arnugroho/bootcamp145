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

import com.xsis.bootcamp.model.Company;
import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.CompanyService;
import com.xsis.bootcamp.util.GeneralVariable;
import com.xsis.bootcamp.viewmodel.ViewCompany;


@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private CompanyService companyService;

	@RequestMapping("/company")
	public String index() {
		return "company/company";
	}

	@RequestMapping("/insert")
	public void insert(Model model, HttpServletRequest request) {
		try {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");

			Personel personel = getUser();
			Date currentDate = new Date();

			Company company = new Company();
			company.setCode(code);
			company.setName(name);
			company.setEmail(email);
			company.setPhone(phone);
			company.setAddress(address);
			company.setCreatedBy(personel.getUsername());
			company.setCreatedDate(currentDate);
			company.setIsDelete(0);
			companyService.insert(company);

			model.addAttribute("success", true);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/get-data")
	public void getData(Model model, HttpServletRequest request) {
		try {
			Collection<Company> listCompany = companyService.listAll();
			Collection<ViewCompany> listViewCompany = new ArrayList<>();
			for(Company company : listCompany) {
				ViewCompany v = new ViewCompany();
				v.setCode(company.getCode());
				v.setName(company.getName());
				v.setEmail(company.getEmail());
				v.setPhone(company.getPhone());
				v.setAddress(company.getAddress());
				v.setIdCompany(company.getId());
				listViewCompany.add(v);
				
			}
			model.addAttribute("listCompany", listViewCompany);
			model.addAttribute("success",true);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			model.addAttribute("success",false);
		}
	}
	
	@RequestMapping("/delete")
	public void delete(Model model, HttpServletRequest request) {
		try {
			String idCompanyReq = request.getParameter("idCompany");
			int idCompany = Integer.parseInt(idCompanyReq);
			Company company = companyService.get(idCompany);
			company.setIsDelete(GeneralVariable.ISDELETE_TRUE);

			companyService.update(company);
			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}
	
	@RequestMapping("/view")
	public void view(Model model, HttpServletRequest request) {
		try {
			String idCompanyReq = request.getParameter("idCompany");
			int idCompany = Integer.parseInt(idCompanyReq);
			Company company = companyService.get(idCompany);

			model.addAttribute("company", company);
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
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			int idCompany = Integer.parseInt(idReq);

			Company company = companyService.get(idCompany);
			company.setCode(code);
			company.setName(name);
			company.setEmail(email);
			company.setPhone(phone);
			company.setAddress(address);
			company.setUpdatedBy(user.getUsername());
			company.setUpdatedDate(currentDate);
			companyService.update(company);

			model.addAttribute("success", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("success", false);
		}
	}

}
