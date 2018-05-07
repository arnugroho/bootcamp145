package com.xsis.bootcamp.viewmodel;

import java.util.Date;

public class ViewRole {
	private String code;
	private String name;
	public Date createdDate;
	public String createdBy;
	private Integer idRole;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer integer) {
		this.idRole = integer;
	}

}
