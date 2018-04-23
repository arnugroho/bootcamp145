package com.xsis.bootcamp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name =  "dosen")
public class Dosen {
	private int idDosen;
	private String firstName;
	private String lastName;
	private String address;
	
	@GeneratedValue
	@Id
	@Column(name = "iddosen", length = 11, nullable = false)
	public int getIdDosen() {
		return idDosen;
	}
	public void setIdDosen(int idDosen) {
		this.idDosen = idDosen;
	}
	
	@Column(name = "firstname", length = 45, nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "lastname", length = 45, nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "address", length = 100, nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
