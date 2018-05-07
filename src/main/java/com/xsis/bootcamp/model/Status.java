package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Status")
public class Status {
	@Id
	@Column(name="id",length=11)
	private int id;
	@Column(name="status",length=11)
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD
=======

	@Column(name = "status", length = 12)
	
>>>>>>> d018d1b3679ce0715285e3c7f4e1ade1c974655b
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
