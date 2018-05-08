package com.xsis.bootcamp.viewmodel;

import java.util.Date;

public class ViewDesign {
	private String code;
	private String requestBy;
	private Date requestDate;
	private Integer assignTo;
	private String status;
	private Date createdDate;
	private String createdBy;
	private Integer idDesign;
	
	public Integer getIdDesign() {
		return idDesign;
	}
	public void setIdDesign(Integer idDesign) {
		this.idDesign = idDesign;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Integer getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(Integer assignTo) {
		this.assignTo = assignTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
}
