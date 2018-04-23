/**
 * 
 */
package com.xsis.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.xsis.bootcamp.model.Personel;
import com.xsis.bootcamp.service.PersonelService;



@Controller
public class BaseController {

	@Autowired
	PersonelService personelService;

	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();

			return userDetail.getUsername();
		}
		return null;
	}
	
	
	public UserDetails getUserDetail() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			/*for (GrantedAuthority a : auth.getAuthorities()) {
			}*/

			return userDetail;
		}
		return null;
	}

	public Personel getUser() {
		String userName = getUserName();
		try {
			Personel personel = personelService.getByUserName(userName);
			return personel;
		} catch (Exception e) {
			return null;
		}
	}
	
	//mendapatkan parent wilayah
	/*public int getWParent() {
		Personel personel = getUser();
		try {
			Wilayah wilayah = personelService.getParentWilayah(personel.getwId());
			return wilayah.getwParent();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}*/
}
