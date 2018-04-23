package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "fakultas")
public class Fakultas {
	private int idFakultas;
	private String namaFakultas;

	@Id
	@Column(name = "idfakultas", length = 11, nullable = false)
	public int getIdFakultas() {
		return idFakultas;
	}

	public void setIdFakultas(int idFakultas) {
		this.idFakultas = idFakultas;
	}

	@Column(name = "namafakultas", length = 45)
	public String getNamaFakultas() {
		return namaFakultas;
	}

	public void setNamaFakultas(String namaFakultas) {
		this.namaFakultas = namaFakultas;
	}

}
