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

	@Column(name = "status", length = 12)
<<<<<<< HEAD
	
=======
>>>>>>> 4a87c5508da4591d5fd9d6eb58f63bddee8df251
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
