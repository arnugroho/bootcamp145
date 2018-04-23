package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="Jurusan")
public class Jurusan {
	
	private int idJurusan;
	private String namaJurusan;
	
	@Id
	@Column(name="id_jurusan", length=11, nullable=false)
	public int getIdJurusan() {
		return idJurusan;
	}
	public void setIdJurusan(int idJurusan) {
		this.idJurusan = idJurusan;
	}
	
	@Column(name="nama_jurusan", length=45)
	public String getNamaJurusan() {
		return namaJurusan;
	}
	public void setNamaJurusan(String namaJurusan) {
		this.namaJurusan = namaJurusan;
	}
	
}
