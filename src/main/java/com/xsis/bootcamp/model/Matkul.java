package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "matkul")
public class Matkul {
	private int idMatkul;
	private String nama;
	private int sks;
	private Jurusan jurusanDesc;

	@GeneratedValue
	@Id
	@Column(name = "idmatkul", length = 11, nullable = false)
	public int getIdMatkul() {
		return idMatkul;
	}

	public void setIdMatkul(int idMatkul) {
		this.idMatkul = idMatkul;
	}

	@Column(name = "nama", length = 45, nullable = false)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "sks", length = 2, nullable = false)
	public int getSks() {
		return sks;
	}

	public void setSks(int sks) {
		this.sks = sks;
	}

	@ManyToOne
	@JoinColumn(name = "jurusan", updatable = false, nullable = false, insertable = false)
	public Jurusan getJurusanDesc() {
		return jurusanDesc;
	}

	public void setJurusanDesc(Jurusan jurusanDesc) {
		this.jurusanDesc = jurusanDesc;
	}
	

}