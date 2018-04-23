package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="Ruangan")
public class Ruangan {
	private int idRuangan;
	private String namaRuangan;
	
	@Id
	@GeneratedValue
	@Column(name = "idRuangan", length = 11, nullable = false)
	public int getIdRuangan() {
		return idRuangan;
	}
	public void setIdRuangan(int idRuangan) {
		this.idRuangan = idRuangan;
	}
	
	@Column(name = "namaRuangan", length = 100)
	public String getNamaRuangan() {
		return namaRuangan;
	}
	public void setNamaRuangan(String namaRuangan) {
		this.namaRuangan = namaRuangan;
	}
	
}
