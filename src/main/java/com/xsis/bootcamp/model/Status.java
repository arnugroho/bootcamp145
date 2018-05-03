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

	@Column(name = "status", length = 12)

=======
	@Column(name = "status", length = 12)
>>>>>>> d62b92fb700abb5c68f122708429e350b69aac88
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
