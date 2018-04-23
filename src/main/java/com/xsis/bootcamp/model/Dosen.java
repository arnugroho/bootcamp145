package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name =  "dosen")
public class Dosen {
	private int nikDosen;
	private String namaDosen;
	private String alamat;
	
	@GeneratedValue
	@Id
	@Column(name = "nikdosen", length = 11, nullable = false)
	public int getNikDosen() {
		return nikDosen;
	}
	public void setNikDosen(int nikDosen) {
		this.nikDosen = nikDosen;
	}
	
	@Column(name = "namadosen", length = 45, nullable = false)
	public String getNamaDosen() {
		return namaDosen;
	}
	public void setNamaDosen(String namaDosen) {
		this.namaDosen = namaDosen;
	}
	
	@Column(name = "alamat", length = 60, nullable = false)
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
}
